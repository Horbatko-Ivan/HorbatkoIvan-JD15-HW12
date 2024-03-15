package org.goit.horbatkoivanhw12.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;
import org.goit.horbatkoivanhw12.entities.Planet;

public class PlanetCrudService {

  private final EntityManagerFactory entityManagerFactory;

  public PlanetCrudService(EntityManagerFactory entityManagerFactory) {
    this.entityManagerFactory = entityManagerFactory;
  }

  public void saveOrUpdate(Planet planet) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    try {
      entityManager.getTransaction().begin();
      if (planet.getId() == null || entityManager.find(Planet.class, planet.getId()) == null) {
        entityManager.persist(planet);
      } else {
        entityManager.merge(planet);
      }
      entityManager.getTransaction().commit();
    } finally {
      if (entityManager.getTransaction().isActive()) {
        entityManager.getTransaction().rollback();
      }
      entityManager.close();
    }
  }

  public void delete(String planetId) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    try {
      entityManager.getTransaction().begin();
      Planet planet = entityManager.find(Planet.class, planetId);
      if (planet != null) {
        entityManager.remove(planet);
      }
      entityManager.getTransaction().commit();
    } finally {
      if (entityManager.getTransaction().isActive()) {
        entityManager.getTransaction().rollback();
      }
      entityManager.close();
    }
  }

  public Planet getById(String id) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    try {
      return entityManager.find(Planet.class, id);
    } finally {
      entityManager.close();
    }
  }

  public List<Planet> getAll() {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    try {
      return entityManager.createQuery("from Planet", Planet.class).getResultList();
    } finally {
      entityManager.close();
    }
  }
}
