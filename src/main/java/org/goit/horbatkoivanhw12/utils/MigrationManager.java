package org.goit.horbatkoivanhw12.utils;

import org.flywaydb.core.Flyway;

@SuppressWarnings("checkstyle:MissingJavadocType")
public class MigrationManager {

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public static void migrateDatabase() {
    Flyway flyway = Flyway.configure()
        .dataSource("jdbc:h2:file:./test", "", "")
        .locations("classpath:db/migration")
        .load();
    flyway.migrate();
  }
}
