package com.ntr153.telusko.docker_student_app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentRepo repo;
    
    @RequestMapping("/getStudents")
    public List<Student> getStudents() {
        // return List.of(
        //     new Student(1, "ABC", 97),
        //     new Student(2, "LMN", 98),
        //     new Student(3, "XYZ", 99)
        // );
        return repo.findAll();
    }

}