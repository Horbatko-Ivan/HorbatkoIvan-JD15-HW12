package org.goit.horbatkoivanhw12.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;
import org.goit.horbatkoivanhw12.entities.Client;

@SuppressWarnings("checkstyle:MissingJavadocType")
public class ClientCrudService {

  private final EntityManagerFactory entityManagerFactory;

  public ClientCrudService(EntityManagerFactory entityManagerFactory) {
    this.entityManagerFactory = entityManagerFactory;
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public void saveOrUpdate(Client client) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    try {
      entityManager.getTransaction().begin();
      if (client.getId() == null) {
        entityManager.persist(client);
      } else {
        entityManager.merge(client);
      }
      entityManager.getTransaction().commit();
    } finally {
      if (entityManager.getTransaction().isActive()) {
        entityManager.getTransaction().rollback();
      }
      entityManager.close();
    }
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public void delete(Long clientId) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    try {
      entityManager.getTransaction().begin();
      Client client = entityManager.find(Client.class, clientId);
      if (client != null) {
        entityManager.remove(client);
      }
      entityManager.getTransaction().commit();
    } finally {
      if (entityManager.getTransaction().isActive()) {
        entityManager.getTransaction().rollback();
      }
      entityManager.close();
    }
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public Client getById(Long id) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    try {
      return entityManager.find(Client.class, id);
    } finally {
      entityManager.close();
    }
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public List<Client> getAll() {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    try {
      return entityManager.createQuery("from Client", Client.class).getResultList();
    } finally {
      entityManager.close();
    }
  }
}
