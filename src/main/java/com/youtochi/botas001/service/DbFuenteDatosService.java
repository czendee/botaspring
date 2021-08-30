package com.youtochi.botas001.service;

import com.youtochi.botas001.model.DbFuenteDatos;
import com.youtochi.botas001.repository.DbFuenteDatosRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class DbFuenteDatosService implements IDbFuenteDatosService{
   
  @Autowired
  public DbFuenteDatosRepository dbFuenteDatosRepository;
  
  @Override 
  public List<DbFuenteDatos> findAll(){
      return dbFuenteDatosRepository.findAll();
  }
  
}
