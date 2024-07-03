package com.ntr153.telusko.spring_data_jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ntr153.telusko.spring_data_jpa.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

    @Query("select s from Student s where s.studentName = ?1")          // Note: parameter number is necessary
    List<Student> findByName(String name);       // object and primary key

    List<Student> findByStudentMarks(int marks);         // Being handled by Domain Specific Languguage
                                                                // Automatic query creation BTS

    List<Student> findByStudentMarksGreaterThan(int marks);     // Automatic query creation BTS
    
}
