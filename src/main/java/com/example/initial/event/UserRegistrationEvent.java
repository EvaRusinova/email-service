package com.example.initial.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@AllArgsConstructor
public class UserRegistrationEvent implements Serializable {
    @Serial
    private static final long serialVersionUID = 898989;
    private String fullName;
    private String email;
}