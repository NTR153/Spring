package com.ormb.app.ormbapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ormb.app.ormbapp.service.MessageService;

 @Controller
//@RestController
public class OrbmLoginPageController {

//      // Map to store predefined user credentials
//      private static final Map<String, String> userCredentials = new HashMap<>();


//    @Autowired
// //    @Qualifier("emailService")
// @Qualifier("smsService")
//    private MessageService emailService;

//      static {
//          // Hardcoded user credentials
//          userCredentials.put("userone", "passone");
//          userCredentials.put("usertwo", "passtwo");
//          userCredentials.put("userthree", "passthree");
//      }

//     @GetMapping("/")
//     public String login() {
//         System.out.println("inside login=========>");

//             // Process the message using the MessageProcessor
//         String emailMessage = emailService.getMessage();
        
//         // Use the emailMessage or return it in the response
//         System.out.println("Email Message: " + emailMessage);
//         // return "<h1>ORMB Logged in</h1>";
//         System.out.println("out login=========>");
//         return "ormbLogin "+emailMessage;
//     }


//       @GetMapping("/kyabhai")
//     public ResponseEntity<String> login1() {
//         System.out.println("inside login=========>");
//         // Your response content
//         String jsonResponse = "{'message': 'mast hain bhai'}";
//         // Create a ResponseEntity with the JSON content and appropriate HTTP status
//         return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
//     }

//         @PostMapping("/login")
//     public String authenticate(@RequestParam String userId, @RequestParam String password, Model model) {
//         // Check if the entered credentials match any predefined user
//         if (userCredentials.containsKey(userId) && userCredentials.get(userId).equals(password)) {
//             // If authenticated, redirect to the home page
//             model.addAttribute("userId", userId); // Pass the username to the home page
//             return "homePage";
//         } else {
//             // If not authenticated, return to the login page with an error message
//             model.addAttribute("error", "Invalid credentials. Please try again.");
//             return "ormbLogin";
//         }
//     }


    @GetMapping("/")
    public String login() {
        System.out.println("inside login=========>");

        return "ormbLogin";
    }

}




