package com.ntr153.telusko.springboot1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component                  // this annotation is liable for springboot framework to create object of the below class after application initialization
public class Alien {

    @Autowired              // this annotation is responsible for connecting laptop class with alien class
    Laptop laptop;          // laptop class also needs to have @Component annotation

    public void code() {
        laptop.compile();
    }
}
