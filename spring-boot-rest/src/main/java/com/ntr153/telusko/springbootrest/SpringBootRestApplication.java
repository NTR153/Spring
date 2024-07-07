package com.ntr153.telusko.springbootrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ntr153.telusko.springbootrest.service.JobService;

@SpringBootApplication
public class SpringBootRestApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootRestApplication.class, args);

		JobService service = context.getBean(JobService.class);

		System.out.println("NTR153 searchByKeyword : " + service.searchByKeyword("Java"));
	}

}