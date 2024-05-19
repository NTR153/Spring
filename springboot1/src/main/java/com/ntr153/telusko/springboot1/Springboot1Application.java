package com.ntr153.telusko.springboot1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Springboot1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Springboot1Application.class, args);
		Alien obj = context.getBean(Alien.class);
		obj.code();
	}
}