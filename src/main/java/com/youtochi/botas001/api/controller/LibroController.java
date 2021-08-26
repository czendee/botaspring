package com.youtochi.botas001.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/* * Created by CZ on 26/08/2021 */
@Controller
public class LibroController {
  // @RequestMapping("/libroson")
  @GetMapping("/libroson")
  public String traeLibrosones(Model model){
    System.out.println("traeLibrosones llamado ...3");
    model.addAttribute("librooos","este es el valor"); 
    return "librosss/lista";
  }
  
//    @GetMapping(value={"/librocual",produces=MediaType.APPLICATION_JSON_VALUE})
  @GetMapping("/libroscual")
  public String traeLibrocuales(  @RequestParam(name="nombre", required=false, defaultValue="mundial") String nombrito, Model model){
    System.out.println("traeLibrocuales llamado ...3");
    model.addAttribute("librooos","este es el valor"+nombrito); 
    return "librosss/lista";
  }
}
