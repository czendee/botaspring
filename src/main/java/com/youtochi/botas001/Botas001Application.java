package com.youtochi.botas001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ComponentScan(basePackages={"com.youtochi"}) //added this line,as in the localhost intellij it restcontrollers work ok, but in heroku i was getting 404
public class Botas001Application {

	public static void main(String[] args) {
		System.out.println("arrancando ...4");
		SpringApplication.run(Botas001Application.class, args);
		System.out.println("arrancado ...4");
	}

}
