package com.ntr153.telusko.springboot1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ntr153.telusko.springboot1.model.Alien;
import com.ntr153.telusko.springboot1.model.Student;
import com.ntr153.telusko.springboot1.service.StudentService;

@SpringBootApplication
public class Springboot1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Springboot1Application.class, args);
		Alien obj = context.getBean(Alien.class);
		obj.code();

		// Laptop lap = context.getBean(Laptop.class);

		// LaptopService lapService = context.getBean(LaptopService.class);
		// lapService.addLaptop(lap);
		
		Student student = context.getBean(Student.class);
		student.setStudentNo(7);
		student.setStudentName("Bilal");
		student.setStudentMarks(0);

		StudentService studentService = context.getBean(StudentService.class);
		studentService.addStudent(student);
	}
}