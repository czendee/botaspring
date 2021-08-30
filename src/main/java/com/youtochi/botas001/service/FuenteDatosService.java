package com.youtochi.botas001.service;

import com.youtochi.botas001.model.FuenteDatos;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class FuenteDatosService {
  
  public FuenteDatos encuentraLaFuenteDatos(String nombre, String tipo){
    FuenteDatos fuente = new FuenteDatos();
    fuente.setNombre(nombre);
    fuente.setTipo(tipo);
    return fuente;
  }
  

  
}
