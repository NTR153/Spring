package com.ntr153.telusko.aws_web_app;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {
    
    @GetMapping("/")
    public String greeString() {
        return "Welcome to Simple Web App for AWS Elastic Beanstalk";
    }
    

    @GetMapping("info")
    public String aboutMachine() {

        String os = System.getProperty("os.name");
        String version = System.getProperty("os.version");
        String architecture = System.getProperty("os.arch");
        String javaHome = System.getenv("JAVA_HOME");
        String javaVersion = System.getProperty("java.version");
        String user = System.getProperty("user.name");

        return String.format("OS : %s | "
                            + "OS Version : %s | "
                            + "OS Architecture : %s | "
                            + "Java Home : %s | "
                            + "Java Version : %s | "
                            + "User : %s", os, version, architecture, javaHome, javaVersion, user);
    }
    
}