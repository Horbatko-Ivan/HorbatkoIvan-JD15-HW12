package org.goit.horbatkoivanhw12.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@SuppressWarnings("checkstyle:MissingJavadocType")
@Entity
public class Planet {

  @Id
  private String id;
  private String name;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
