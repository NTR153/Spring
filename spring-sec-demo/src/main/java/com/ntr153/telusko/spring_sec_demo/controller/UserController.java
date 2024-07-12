package com.ntr153.telusko.spring_sec_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ntr153.telusko.spring_sec_demo.model.User;
import com.ntr153.telusko.spring_sec_demo.service.UserService;

@RestController
public class UserController {
    
    @Autowired
    private UserService service;

    @PostMapping("registerUser")
    public User register(@RequestBody User user) {
        service.saveUser(user);
        return user;
    }
}
