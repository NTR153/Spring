// package com.ormb.app.ormbapp.service.kafka;

// import org.springframework.kafka.annotation.KafkaListener;
// import org.springframework.stereotype.Service;

// @Service
// public class KafkaConsumerService {
    
//     @KafkaListener(topics = "my-topic", groupId = "my-group-id")
//     public String consumeMessage(String message) {
//         System.out.println("Received message: " + message);

//         System.out.println("###############################################################################################################");
//         return "Received message: " + message;
//     }

//     // public String getLatestMessage() {
//     //     throw new UnsupportedOperationException("Unimplemented method 'getLatestMessage'");
//     // }
// }
