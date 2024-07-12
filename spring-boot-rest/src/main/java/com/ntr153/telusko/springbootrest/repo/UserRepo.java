package com.ntr153.telusko.springbootrest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntr153.telusko.springbootrest.model.User;

public interface UserRepo extends JpaRepository<User, String> {

    User findByUsername(String username);
    
}
