package com.ntr153.telusko.springboot1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntr153.telusko.springboot1.model.Laptop;
import com.ntr153.telusko.springboot1.repository.LaptopRepository;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository lapRepo;

    public void addLaptop(Laptop lap) {
        System.out.println("Laptop Add Called");
        lapRepo.save(lap);
    }

}
