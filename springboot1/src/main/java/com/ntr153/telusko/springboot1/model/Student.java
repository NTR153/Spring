package com.ntr153.telusko.springboot1.model;

import org.springframework.stereotype.Component;

@Component
public class Student {

    private int studentNo;
    private String studentName;
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
