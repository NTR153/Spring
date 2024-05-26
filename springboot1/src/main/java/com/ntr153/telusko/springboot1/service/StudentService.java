package com.ntr153.telusko.springboot1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntr153.telusko.springboot1.model.Student;
import com.ntr153.telusko.springboot1.repository.StudentRepository;

@Service
public class StudentService {

    private StudentRepository studentRepo;

    public void addStudent(Student student) {
        studentRepo.save(student);
    }

    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    public StudentRepository getStudentRepo() {
        return studentRepo;
    }

    @Autowired
    public void setStudentRepo(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }
}
