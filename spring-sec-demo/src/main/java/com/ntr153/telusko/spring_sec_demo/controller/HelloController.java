package com.ntr153.telusko.spring_sec_demo.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {

    @GetMapping("hello")
    public String greet(HttpServletRequest request) {           // for normal SpringWeb, we get HttpServletRequest
                                                                // for SpringReactive, it may be different
        return "Hello World sessionId : " + request.getSession().getId() + " \nNote: not a good idea to show session id";
    }

    @GetMapping("about")
    public String abouString(HttpServletRequest request) {
        return "Spring Security Demo sessionId : " + request.getSession().getId() + " \nNote: not a good idea to show session id";
    }
    
    
}