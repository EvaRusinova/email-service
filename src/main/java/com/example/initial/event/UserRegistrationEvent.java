package com.example.initial.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
public class UserRegistrationEvent implements Serializable {
    private String userName;
    private String email;
}