package com.ntr153.telusko.spring_data_jpa;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ntr153.telusko.spring_data_jpa.model.Student;
import com.ntr153.telusko.spring_data_jpa.repo.StudentRepo;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);

		StudentRepo repo = context.getBean(StudentRepo.class);
		
		Student s1 = context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);
		Student s3 = context.getBean(Student.class);

		s1.setStudentNo(7);
		s1.setStudentName("Doraemon");
		s1.setStudentMarks(78);

		s2.setStudentNo(8);
		s2.setStudentName("Dorami");
		s2.setStudentMarks(80);

		s3.setStudentNo(9);
		s3.setStudentName("Mini Doraemon");
		s3.setStudentMarks(54);

		/*
		 * Default Methods by JpaRepository
		 */

		// repo.save(s1);			// can be used for creating and updating objects (rows)
		// repo.save(s2);
		// repo.save(s3);

		repo.delete(s3);

		System.out.println("findAll : " + repo.findAll());

		Optional<Student> s = repo.findById(9);			// be default, repo returns an optional object
		System.out.println("findById : " + s.orElse(new Student()));		// orElse() is a method for optional object

		/*
		 * Custom Methods
		 */

		System.out.println("findByName : " + repo.findByName("Dorami"));

		System.out.println("findByStudentMarks : " + repo.findByStudentMarks(78));

		System.out.println("findByStudentMarksGreaterThan : " + repo.findByStudentMarksGreaterThan(90));
	}

}
