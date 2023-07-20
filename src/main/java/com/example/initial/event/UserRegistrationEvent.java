package com.example.initial.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.io.Serializable;

@Getter
@AllArgsConstructor
public class UserRegistrationEvent implements Serializable {
    private String userName;
    private String email;
}