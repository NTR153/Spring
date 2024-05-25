package com.ntr153.telusko.springboot1.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Desktop implements Computer {

    public void compile() {
        System.out.println("Compiling in Desktop ...");
    }

}
