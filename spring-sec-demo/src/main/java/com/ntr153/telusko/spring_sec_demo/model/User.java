package com.ntr153.telusko.spring_sec_demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="spring_sec_demo_users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;
    @Id
    private String username;
    private String password;
    private String role;
}
