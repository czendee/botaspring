package com.youtochi.botas001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.youtochi.botas001.api.controller.LibroRestController;
//import org.springframework.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration
//@ComponentScan (basePackageClasses=LibroRestController.class)
public class Botas001Application  {

	public static void main(String[] args) {
		System.out.println("arrancando ...5");
		SpringApplication.run(Botas001Application.class, args);
		System.out.println("arrancado ...4");
	}
	


}
