package org.goit.horbatkoivanhw12.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

@SuppressWarnings("checkstyle:MissingJavadocType")
public class HibernateUtil {

  private static final SessionFactory sessionFactory = buildSessionFactory();

  private static SessionFactory buildSessionFactory() {
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .configure("hibernate.cfg.xml")
        .build();
    try {
      Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
      return metadata.getSessionFactoryBuilder().build();
    } catch (Exception ex) {
      StandardServiceRegistryBuilder.destroy(registry);
      throw new RuntimeException("Failed to build SessionFactory: " + ex.getMessage(), ex);
    }
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  public static void shutdown() {
    getSessionFactory().close();
  }
}
