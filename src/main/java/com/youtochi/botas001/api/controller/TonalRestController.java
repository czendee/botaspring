package com.youtochi.botas001.api.controller;

import com.youtochi.botas001.model.FuenteDatos;
import com.youtochi.botas001.model.DbFuenteDatos;
import com.youtochi.botas001.model.FuenteDatosRequest;
import com.youtochi.botas001.model.Librito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.youtochi.botas001.model.StudentTest;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import java.util.Map;
import java.util.Iterator;
import java.util.Set;


//import 

@RestController
@RequestMapping("/v1/api")
public class TonalRestController {

  @GetMapping(value = { "/tonaljson" },
              produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public Librito traeLibrojson(@RequestParam(name="nombre", required=false, defaultValue="falto el valor") String dos){
    System.out.println("LibroRestController --- traeLibrojson llamado ...4");
    Librito silibro= new Librito("carlos zendejas","489.00");
    // return "{'aa':'bb'}";
    return silibro;
  }

  @GetMapping(value = { "/listatonaljson" },
              produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public List traeListaLibrojson(@RequestParam(name="nombre", required=false, defaultValue="falto el valor") String dos){
    System.out.println("LibroRestController --- traeListaLibrojson llamado ...4");
    Librito silibro= new Librito("carlos zendejas","489.00");
    Librito silibro2= new Librito("carlos zendejas","489.00");
    List lalista = new ArrayList();
    // return "{'aa':'bb'}";
    lalista.add(silibro);
    lalista.add(silibro2);
    return lalista;
  }



}