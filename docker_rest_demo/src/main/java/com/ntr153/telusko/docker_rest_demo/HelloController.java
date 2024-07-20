package com.ntr153.telusko.docker_rest_demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String greet() {
        return "Hello World";
    }
    
}
