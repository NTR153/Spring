package com.ormb.app.ormbapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assuming you want an auto-generated ID
    private Long perId;

    @SuppressWarnings("unused")
    private String fName;
    @SuppressWarnings("unused")
    private String lName;
    @SuppressWarnings("unused")
    private String perIdCode;

    
}
