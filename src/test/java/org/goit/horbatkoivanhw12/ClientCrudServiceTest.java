package org.goit.horbatkoivanhw12;

import static org.mockito.Mockito.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.goit.horbatkoivanhw12.entities.Client;
import org.goit.horbatkoivanhw12.services.ClientCrudService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class ClientCrudServiceTest {

  @Mock
  private SessionFactory sessionFactory;

  @Mock
  private Session session;

  @Mock
  private Transaction transaction;

  private ClientCrudService clientService;

  @Test
  void saveOrUpdateTest() {
    EntityManager entityManager = mock(EntityManager.class);
    EntityManagerFactory entityManagerFactory = mock(EntityManagerFactory.class);
    when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
    when(entityManager.getTransaction()).thenReturn(mock(EntityTransaction.class));

    ClientCrudService service = new ClientCrudService(entityManagerFactory);
    Client client = new Client();
    client.setName("Test Client");

    service.saveOrUpdate(client);

    verify(entityManager, times(1)).persist(any(Client.class));
  }
}
