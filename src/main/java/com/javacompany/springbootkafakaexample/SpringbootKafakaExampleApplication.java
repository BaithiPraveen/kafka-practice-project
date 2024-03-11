package com.javacompany.springbootkafakaexample;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootKafakaExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootKafakaExampleApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
