package com.javacompany.springbootkafakaexample.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducer {

    private final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    @Value("${spring.kafka.topic.name}")
    String topicName;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        LOGGER.info(String.format("Message sent : %s ", message));
        CompletableFuture<SendResult<String, String>> sentMessage = kafkaTemplate.send(topicName, "hello", message);


    }
}
