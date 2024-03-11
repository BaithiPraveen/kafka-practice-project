package com.javacompany.springbootkafakaexample.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;

}
