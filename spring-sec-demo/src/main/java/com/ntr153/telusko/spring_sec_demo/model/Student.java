package com.ntr153.telusko.spring_sec_demo.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private int sId;
    private String sNmae;
    private int marks;
}
