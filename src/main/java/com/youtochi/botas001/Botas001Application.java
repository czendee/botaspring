package com.youtochi.botas001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Botas001Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		System.out.println("arrancando ...4");
		SpringApplication.run(Botas001Application.class, args);
		System.out.println("arrancado ...4");
	}
	
  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	  System.out.println("configurando ...4");
      return builder.sources(Botas001Application.class);
  }	

}
