package com.ntr153.telusko.springboot1.service;

import com.ntr153.telusko.springboot1.model.Student;
import com.ntr153.telusko.springboot1.repository.StudentRepository;

public class StudentService {

    private StudentRepository studentRepo;

    public void addStudent(Student student) {
        studentRepo.save(student);
    }
}
