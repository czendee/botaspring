package com.youtochi.botas001.api.controller;

import com.youtochi.botas001.model.FuenteDatos;
import com.youtochi.botas001.model.FuenteDatosRequest;
import com.youtochi.botas001.model.Librito;
import com.youtochi.botas001.service.FuenteDatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class LibroRestController {
  
  @GetMapping(value = { "/librojson" },
              produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public Librito traeLibrojson(@RequestParam(name="nombre", required=false, defaultValue="falto el valor") String dos){
    System.out.println("LibroRestController --- traeLibrojson llamado ...4");
    Librito silibro= new Librito("carlos zendejas","489.00");
    // return "{'aa':'bb'}";
    return silibro;
  }
  
  @GetMapping(value = { "/listalibrojson" },
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
  
  @GetMapping(value = { "/listalibrotext" },
              produces = MediaType.TEXT_PLAIN_VALUE)
  @ResponseBody
  public String traeListaLibrotext(@RequestParam(name="nombre", required=false, defaultValue="falto el valor") String dos){
    System.out.println("LibroRestController --- traeListaLibrotext llamado ...5");
    Librito silibro= new Librito("carlos zendejas","489.00");
    Librito silibro2= new Librito("carlos i zendejas","489.00");
    List lalista = new ArrayList();
    // return "{'aa':'bb'}";
    lalista.add(silibro);
    lalista.add(silibro2);
    return lalista.toString();
  }
  
  @Autowired
  private FuenteDatosService fuenteDatosService;
  
  @RequestMapping(value={"fuente.json","fuente"},
                  method=RequestMethod.POST,
                  consumes ={"application/json","application/xml"},
                  produces={"application/json"}
                 )
  public FuenteDatos obtenFuenteDatosJson(@RequestBody FuenteDatosRequest fuenteDatosRequest){
    System.out.println("LibroRestController --- obtenFuenteDatosJson llamado ...5");
    return this.fuenteDatosService.encuentraLaFuenteDatos(fuenteDatosRequest.getLogin(),fuenteDatosRequest.getPassword());
  }
  
  @RequestMapping(value={"fuente.xml"}, 
                  method=RequestMethod.POST,
                  consumes ={"application/json","application/xml"},
                  produces={"application/xml"}
                 )
  public FuenteDatos obtenFuenteDatosXml(@RequestBody FuenteDatosRequest fuenteDatosRequest){
    System.out.println("LibroRestController --- obtenFuenteDatosXml llamado ...5");
    return this.fuenteDatosService.encuentraLaFuenteDatos(fuenteDatosRequest.getLogin(),fuenteDatosRequest.getPassword());
  }
}