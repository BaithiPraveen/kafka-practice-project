package com.javacompany.springbootkafakaexample.kafka;

import com.javacompany.springbootkafakaexample.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
    @Value("${spring.kafka.topic-json.name}")
    String topicName;
    @Autowired
    private KafkaTemplate<String, UserDTO> kafkaTemplate;

    public void sendMessage(UserDTO userObject) {

        Message<UserDTO> message = MessageBuilder
                .withPayload(userObject)
                .setHeader(KafkaHeaders.TOPIC, topicName)
                .build();
        kafkaTemplate.send(message);
    }
}