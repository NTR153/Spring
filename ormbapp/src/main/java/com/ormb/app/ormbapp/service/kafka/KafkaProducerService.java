// package com.ormb.app.ormbapp.service.kafka;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.kafka.core.KafkaTemplate;
// import org.springframework.stereotype.Service;

// @Service
// public class KafkaProducerService {

//     @Autowired
//     private KafkaTemplate<String, String> kafkaTemplate;

//     public void sendMessage(String topic, String message) {
//         kafkaTemplate.send(topic, message);
//         System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.");
//     }
// }
