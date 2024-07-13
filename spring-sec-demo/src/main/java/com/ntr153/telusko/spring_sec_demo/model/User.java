package com.ntr153.telusko.spring_sec_demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    // @GeneratedValue(strategy = GenerationType.IDENTITY)     // creates id automatically, but must be a part of primary key
    private int id;
    @Id
    private String username;
    private String password;
    private String role;
    
}