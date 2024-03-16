package org.goit.horbatkoivanhw12.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;
import org.goit.horbatkoivanhw12.entities.Ticket;

@SuppressWarnings("checkstyle:MissingJavadocType")
public class TicketCrudService {

  private final EntityManagerFactory entityManagerFactory;

  public TicketCrudService(EntityManagerFactory entityManagerFactory) {
    this.entityManagerFactory = entityManagerFactory;
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public void saveOrUpdate(Ticket ticket) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    try {
      entityManager.getTransaction().begin();
      if (ticket.getId() == null || entityManager.find(Ticket.class, ticket.getId()) == null) {
        entityManager.persist(ticket);
      } else {
        entityManager.merge(ticket);
      }
      entityManager.getTransaction().commit();
    } catch (Exception e) {
      entityManager.getTransaction().rollback();
      throw e;
    } finally {
      entityManager.close();
    }
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public void delete(Long ticketId) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    try {
      entityManager.getTransaction().begin();
      Ticket ticket = entityManager.find(Ticket.class, ticketId);
      if (ticket != null) {
        entityManager.remove(ticket);
        System.out.println("Ticket with ID: " + ticketId + " has been deleted.");
      } else {
        System.out.println("Ticket with ID: " + ticketId + " not found.");
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
  public Ticket getById(Long id) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    try {
      Ticket ticket = entityManager.find(Ticket.class, id);
      if (ticket != null) {
        return ticket;
      } else {
        System.out.println("Ticket with ID: " + id + " not found.");
        return null;
      }
    } finally {
      entityManager.close();
    }
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public List<Ticket> getAll() {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    try {
      return entityManager.createQuery("from Ticket", Ticket.class).getResultList();
    } finally {
      entityManager.close();
    }
  }
}
