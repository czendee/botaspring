package com.youtochi.botas001.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.youtochi.botas001.model.DbFuenteDatos;

public interface DbFuenteDatosRepository extends MongoRepository<DbFuenteDatos, String> {

  public DbFuenteDatos findByName(String name);
  public List<DbFuenteDatos> findByUrl(String url);

}
