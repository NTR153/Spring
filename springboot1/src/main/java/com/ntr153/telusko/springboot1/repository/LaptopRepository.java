package com.ntr153.telusko.springboot1.repository;

import org.springframework.stereotype.Repository;

import com.ntr153.telusko.springboot1.model.Laptop;

@Repository
public class LaptopRepository {

    public void save(Laptop lap) {
        System.out.println("Laptop Saved in database");
    }
}
