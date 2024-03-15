package org.goit.horbatkoivanhw12.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Ticket {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private Client client;
  @ManyToOne
  private Planet fromPlanet;
  @ManyToOne
  private Planet toPlanet;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public Planet getFromPlanet() {
    return fromPlanet;
  }

  public void setFromPlanet(Planet fromPlanet) {
    this.fromPlanet = fromPlanet;
  }

  public Planet getToPlanet() {
    return toPlanet;
  }

  public void setToPlanet(Planet toPlanet) {
    this.toPlanet = toPlanet;
  }

}
