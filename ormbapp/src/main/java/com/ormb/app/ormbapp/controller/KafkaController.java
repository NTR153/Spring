// package com.ormb.app.ormbapp.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PatchMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.ormb.app.ormbapp.service.kafka.KafkaConsumerService;
// import com.ormb.app.ormbapp.service.kafka.KafkaProducerService;

// @RestController
// @RequestMapping("/kafka")
// public class KafkaController {

//     @Autowired
//     private  KafkaProducerService kafkaProducerService;
//     @Autowired
//     private  KafkaConsumerService kafkaConsumerService;

//     // @Autowired
//     // public KafkaController(
//     //         KafkaProducerService kafkaProducerService,
//     //         KafkaConsumerService kafkaConsumerService) {
//     //     this.kafkaProducerService = kafkaProducerService;
//     //     this.kafkaConsumerService = kafkaConsumerService;
//     // }

//     // @PostMapping("/send")
//     // public String sendMessage(@RequestParam String message) {
//     //     kafkaProducerService.sendMessage("my-topic", message);
//     //     return "Message sent to Kafka: " + message;
//     // }

//     @GetMapping("/sendMsg/{msg}")
// public String sendMessage(@PathVariable String msg) {
//     try {
//         kafkaProducerService.sendMessage("my-topic", msg);
//         return "Message sent to Kafka using path variable: " + msg;
//     } catch (Exception e) {
//         e.printStackTrace();
//         return "Error sending message to Kafka: " + e.getMessage();
//     }
// }



//     @GetMapping("/sendMsg")
//     public String sendMessage1(@RequestParam String msg) {
//         kafkaProducerService.sendMessage("my-topic", msg);
//         return "Message sent to Kafka using query string: " + msg;
//     }

   

//     @GetMapping("/receive")
//     public String receiveMessage() {
//         // This is just for demonstration. In a real application, you would typically
//         // handle asynchronous message reception using events or callbacks.
//         String receivedMessage = kafkaConsumerService.consumeMessage("yobro");
//         return "Received message from Kafka: " + receivedMessage;
//     }
// }
