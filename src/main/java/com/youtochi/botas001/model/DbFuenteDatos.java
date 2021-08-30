package com.youtochi.botas001.model;

import org.springframework.data.annotation.Id;

@Document (collection="youtochidatasource")
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

  public void setName (String name) { this.name =name;}
  
  public String getName () { return this.name;}
  
  public void setUrl (String url) { this.url =url;}
  
  public String getUrl () { return this.url;}
}
