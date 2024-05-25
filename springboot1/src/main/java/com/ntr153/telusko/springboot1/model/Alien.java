package com.ntr153.telusko.springboot1.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component                  // this annotation is liable for springboot framework to create object of the below class after application initialization
public class Alien {

    @Value("25")
    private int age;

    // @Autowired              // this annotation is responsible for connecting laptop class with alien class
    private Computer com;          // laptop class also needs to have @Component annotation

    public void code() {
        com.compile();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Computer getCom() {
        return com;
    }

    @Autowired
    public void setCom(Computer com) {
        this.com = com;
    }
}
