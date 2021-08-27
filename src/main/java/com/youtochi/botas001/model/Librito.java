package com.youtochi.botas001.model;

public class Librito {
  String nombre;
  String valor;
  
  public Librito(String nombre, String valor) { this.nombre = nombre; this.valor = valor; } 
  public Librito() { }
  public String getNombre() { return nombre; }
  public void setNombre(String nombre) { this.nombre = nombre; }
  public String getValor() { return valor; }
  public void setValor(String valor) { this.valor = valor; }
  
  @Override public String toString() { 
    return "Librito{" + "nombre='" + nombre + '\'' + ", valor='" + valor + '\'' + '}';
  }
}
