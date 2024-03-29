package com.javacompany.springbootkafakaexample.controller;

import com.javacompany.springbootkafakaexample.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class MessageController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/publish/")
    public ResponseEntity<String> getMessage(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("message sent to the topic");
    }

}
