package com.ntr153.telusko.spring_sec_demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.ntr153.telusko.spring_sec_demo.model.Student;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class StudentController {
    
    List<Student> students = new ArrayList<>(List.of(
        new Student(1,"Suneo Honekawa",68),
        new Student(2,"Takeshi Gouda",60),
        new Student(3,"Nobita Nobi",45)
    ));

    @GetMapping("csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
    // Note: this requires the project to have csrf token.
    // this can be enabled in SecurityConfig. But if using stateless API, no CSRF issue never occur

    @GetMapping("students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("addStudent")
    public void addStudent(@RequestBody Student student) {
        students.add(student);
    }
}
