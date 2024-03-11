package com.javacompany.springbootkafakaexample.controller;

import com.javacompany.springbootkafakaexample.dto.UserDTO;
import com.javacompany.springbootkafakaexample.kafka.JsonKafkaProducer;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/kafka")

public class JsonMessageController {

    private JsonKafkaProducer jsonKafkaProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody UserDTO user) {
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("json message sent successfully...!");
    }
}
