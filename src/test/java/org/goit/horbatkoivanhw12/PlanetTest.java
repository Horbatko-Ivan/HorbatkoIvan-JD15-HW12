package org.goit.horbatkoivanhw12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.goit.horbatkoivanhw12.entities.Planet;
import org.junit.jupiter.api.Test;

class PlanetTest {

  @Test
  void testPlanetSettersAndGetters() {
    Planet planet = new Planet();
    planet.setId("MARS");
    planet.setName("Mars");

    assertEquals("MARS", planet.getId());
    assertEquals("Mars", planet.getName());
  }
}
