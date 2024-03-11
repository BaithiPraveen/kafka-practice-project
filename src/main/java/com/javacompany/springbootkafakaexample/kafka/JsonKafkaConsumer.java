package com.javacompany.springbootkafakaexample.kafka;

import com.javacompany.springbootkafakaexample.dto.UserDTO;
import com.javacompany.springbootkafakaexample.entity.User;
import com.javacompany.springbootkafakaexample.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JsonKafkaConsumer {

    final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(UserDTO userDTO) {
        User user = modelMapper.map(userDTO,User.class);
        userRepository.save(user);
        LOGGER.info(String.format("received msg from producer -> : %s", userDTO.toString()));
    }
}
