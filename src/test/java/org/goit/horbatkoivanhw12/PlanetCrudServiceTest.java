package org.goit.horbatkoivanhw12;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.goit.horbatkoivanhw12.entities.Planet;
import org.goit.horbatkoivanhw12.services.PlanetCrudService;
import org.junit.jupiter.api.Test;

class PlanetCrudServiceTest {

  @Test
  void saveOrUpdateTest() {
    EntityManager entityManager = mock(EntityManager.class);
    EntityManagerFactory entityManagerFactory = mock(EntityManagerFactory.class);
    when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
    when(entityManager.getTransaction()).thenReturn(mock(EntityTransaction.class));

    PlanetCrudService service = new PlanetCrudService(entityManagerFactory);
    Planet planet = new Planet();
    planet.setId("EARTH");
    planet.setName("Earth");

    service.saveOrUpdate(planet);

    verify(entityManager, times(1)).persist(any(Planet.class));
  }
}
