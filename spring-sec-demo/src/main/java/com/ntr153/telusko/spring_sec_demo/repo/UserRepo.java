package com.ntr153.telusko.spring_sec_demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntr153.telusko.spring_sec_demo.model.User;

public interface UserRepo extends JpaRepository<User, String> {

    User findByUsername(String username);
    
}
