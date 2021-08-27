package com.youtochi.aprende001.service;

import com.youtochi.aprende001.model.FuenteDatos;
import org.springframework.stereotype.Service;

@Service
public class FuenteDatosService {
  
  public FuenteDatos encuentraLaFuenteDatos(String nombre, String tipo){
    FuenteDatos fuente = new FuenteDatos();
    fuente.setNombre(nombre);
    fuente.setTipo(tipo);
    return fuente;
  }
}