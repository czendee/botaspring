package com.youtochi.botas001.model;

import org.springframework.data.annotation.Id;


public class DbFuenteDatos {

  @Id
  public String id;

  public String name;
  public String url;

  public DbFuenteDatos() {}

  public DbFuenteDatos(String ame, String url) {
    this.name = name;
    this.url = url;
  }

  @Override
  public String toString() {
    return String.format(
        "DbFuenteDatos[id=%s, name='%s', url='%s']",
        id, name, url);
  }

}
