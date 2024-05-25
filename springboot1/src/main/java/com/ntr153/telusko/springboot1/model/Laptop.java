package com.ntr153.telusko.springboot1.model;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {

    public void compile() {
        System.out.println("Compiling in Laptop ...");
    }

}
