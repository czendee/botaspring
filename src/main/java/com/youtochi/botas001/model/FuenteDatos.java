package com.youtochi.aprende001.model;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "datasource") 
@XmlAccessorType(XmlAccessType.FIELD) 
public class FuenteDatos { 
  
  @XmlElement 
  private String nombre;
  @XmlElement
  private String tipo;
  public FuenteDatos(String nombre, String tipo) {
    this.nombre = nombre; this.tipo = tipo;
  }
  public FuenteDatos() { } 
  public String getNombre() { return nombre; }
  public void setNombre(String nombre) { this.nombre = nombre; }
  public String getTipo() { return tipo; }
  public void setTipo(String tipo) { this.tipo = tipo; }
  @Override public String toString() { 
    return "FuenteDatos{" + "nombre='" + nombre + '\'' + ", tipo='" + tipo + '\'' + '}';
  }
}
