package com.ntr153.telusko.spring_sec_demo.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ntr153.telusko.spring_sec_demo.model.User;
import com.ntr153.telusko.spring_sec_demo.service.JwtService;
import com.ntr153.telusko.spring_sec_demo.service.UserService;

import io.jsonwebtoken.io.DecodingException;
import io.jsonwebtoken.security.InvalidKeyException;

@RestController
public class UserController {
    
    @Autowired
    private UserService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("registerUser")
    public User register(@RequestBody User user) {
        service.saveUser(user);
        return user;
    }

    @PostMapping("login")
    public String login(@RequestBody User user) throws InvalidKeyException, DecodingException, NoSuchAlgorithmException {
        
        Authentication authentication = authenticationManager.
                                    authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (authentication.isAuthenticated())
            return jwtService.generateToken(user.getUsername());

        return "Login Failed";
    }
    
}
