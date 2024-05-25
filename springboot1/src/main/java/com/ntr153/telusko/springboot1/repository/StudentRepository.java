package com.ntr153.telusko.springboot1.repository;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ntr153.telusko.springboot1.model.Student;

public class StudentRepository {

    private JdbcTemplate template;

    public void save(Student student) {
        template.execute("SELECT * FROM STUDENT");
    }

}
