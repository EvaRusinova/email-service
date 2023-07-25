package com.example.initial.service;

import com.example.initial.entity.User;

public interface RegistrationService {

    void sendEmailVerifiedMessage(User user);

}