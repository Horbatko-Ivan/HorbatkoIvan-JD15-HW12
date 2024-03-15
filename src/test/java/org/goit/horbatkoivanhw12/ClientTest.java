package org.goit.horbatkoivanhw12;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.goit.horbatkoivanhw12.entities.Client;
import org.junit.jupiter.api.Test;

class ClientTest {

  @Test
  void testClientCreation() {
    Client client = new Client();
    assertNotNull(client);
  }

  @Test
  void testClientSetName() {
    Client client = new Client();
    client.setName("John");
    assertEquals("John", client.getName());
  }
}
