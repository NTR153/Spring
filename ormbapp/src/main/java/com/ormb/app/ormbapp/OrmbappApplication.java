package com.ormb.app.ormbapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ormb.app.ormbapp.service.MessageService;


@SpringBootApplication
public class OrmbappApplication {
	



	public static void main(String[] args) {
		SpringApplication.run(OrmbappApplication.class, args);
		System.out.println("ORMB application started brocode");
  

        
	}

}
