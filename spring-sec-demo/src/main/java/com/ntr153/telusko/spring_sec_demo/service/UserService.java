package com.ntr153.telusko.spring_sec_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;
import org.springframework.stereotype.Service;

import com.ntr153.telusko.spring_sec_demo.model.User;
import com.ntr153.telusko.spring_sec_demo.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(BCryptVersion.$2A, 12);   
            // this can also be configured as a bean in SecurityConfig

    public void saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
    }
    

}
