package com.ormb.app.ormbapp.entities;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assuming you want an auto-generated ID
    private Long perId;

    private String fName;
    private String lName;
    private String perIdCode;

    
}
