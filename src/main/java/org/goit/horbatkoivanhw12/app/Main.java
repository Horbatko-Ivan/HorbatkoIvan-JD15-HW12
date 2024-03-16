package org.goit.horbatkoivanhw12.app;

import java.util.List;
import org.goit.horbatkoivanhw12.entities.Client;
import org.goit.horbatkoivanhw12.entities.Planet;
import org.goit.horbatkoivanhw12.entities.Ticket;
import org.goit.horbatkoivanhw12.services.ClientCrudService;
import org.goit.horbatkoivanhw12.services.PlanetCrudService;
import org.goit.horbatkoivanhw12.services.TicketCrudService;
import org.goit.horbatkoivanhw12.utils.HibernateUtil;
import org.goit.horbatkoivanhw12.utils.MigrationManager;

@SuppressWarnings("checkstyle:MissingJavadocType")
public class Main {

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public static void main(String[] args) {

    try {
      ClientCrudService clientService = new ClientCrudService(HibernateUtil.getSessionFactory());
      PlanetCrudService planetService = new PlanetCrudService(HibernateUtil.getSessionFactory());
      TicketCrudService ticketService = new TicketCrudService(HibernateUtil.getSessionFactory());

      MigrationManager.migrateDatabase();

      Client newClient = new Client();
      newClient.setName("Test Client");
      clientService.saveOrUpdate(newClient);

      System.out.println("All clients:");
      List<Client> clients = clientService.getAll();
      clients.forEach(client -> System.out.println(client.getId() + ": " + client.getName()));

      Client clientToDelete = clientService.getById(1L);
      if (clientToDelete != null) {
        clientService.delete(clientToDelete.getId());
        System.out.println("Client deleted successfully.");
      }

      System.out.println("All planets:");
      List<Planet> planets = planetService.getAll();
      planets.forEach(planet -> System.out.println(planet.getId() + ": " + planet.getName()));

      Ticket newTicket = new Ticket();
      newTicket.setClient(clients.get(0));
      newTicket.setFromPlanet(planets.get(0));
      newTicket.setToPlanet(planets.get(1));
      ticketService.saveOrUpdate(newTicket);

      System.out.println("All tickets:");
      List<Ticket> tickets = ticketService.getAll();
      tickets.forEach(ticket -> System.out.println("Ticket ID: " + ticket.getId()
          + ", Client: " + ticket.getClient().getName()));

    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      HibernateUtil.shutdown();
    }
  }
}
