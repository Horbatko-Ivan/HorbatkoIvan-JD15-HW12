package org.goit.horbatkoivanhw12.app;

import java.util.List;
import org.flywaydb.core.Flyway;
import org.goit.horbatkoivanhw12.entities.Client;
import org.goit.horbatkoivanhw12.entities.Planet;
import org.goit.horbatkoivanhw12.services.ClientCrudService;
import org.goit.horbatkoivanhw12.services.PlanetCrudService;
import org.goit.horbatkoivanhw12.utils.HibernateUtil;

@SuppressWarnings("checkstyle:MissingJavadocType")
public class Main {

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public static void main(String[] args) {

    try {
      ClientCrudService clientService = new ClientCrudService(HibernateUtil.getSessionFactory());
      PlanetCrudService planetService = new PlanetCrudService(HibernateUtil.getSessionFactory());
      Flyway flyway = Flyway.configure()
          .dataSource("jdbc:h2:file:./test", "", "")
          .locations("classpath:db/migration")
          .load();
      flyway.migrate();

      Client newClient = new Client();
      newClient.setName("Test Client");
      clientService.saveOrUpdate(newClient);

      System.out.println("All clients:");
      List<Client> clients = clientService.getAll();
      for (Client client : clients) {
        System.out.println(client.getId() + ": " + client.getName());
      }

      Client clientToDelete = clientService.getById(1L);
      if (clientToDelete != null) {
        clientService.delete(clientToDelete.getId());
        System.out.println("Client deleted successfully.");
      }

      System.out.println("All planets:");
      List<Planet> planets = planetService.getAll();
      for (Planet planet : planets) {
        System.out.println(planet.getId() + ": " + planet.getName());
      }

    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      HibernateUtil.shutdown();
    }
  }
}
