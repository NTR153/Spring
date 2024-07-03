package com.ntr153.telusko.spring_data_jpa.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Component
@Entity                     // JPA for mapping Student class with Student Table, needs an identifier
@Scope("prototype")
public class Student {

    @Id
    @Column(name = "S_ID")      // If we don't specify column name, JPA will try to search for underscore separated name
    private int studentNo;

    @Column(name = "S_NAME")
    private String studentName;

    @Column(name = "MARKS")
    private int studentMarks;
    
    @Override
    public String toString() {
        return "Student [studentNo=" + studentNo + ", studentName=" + studentName + ", studentMarks=" + studentMarks
                + "]\n";
    }

    public int getStudentNo() {
        return studentNo;
    }
    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public int getStudentMarks() {
        return studentMarks;
    }
    public void setStudentMarks(int studentMarks) {
        this.studentMarks = studentMarks;
    }
}
