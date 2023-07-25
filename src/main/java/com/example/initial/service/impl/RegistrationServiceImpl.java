package com.example.initial.service.impl;

import com.example.initial.entity.User;
import com.example.initial.event.UserRegistrationEvent;
import com.example.initial.messaging.EventPublisher;
import com.example.initial.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    @Value("${rabbitmq.exchanges.email-verification-ex}")
    private String emailVerificationExchange;

    @Value("${rabbitmq.routing-keys.email-verification-rk}")
    private String emailVerificationRk;

    private final EventPublisher eventPublisher;

    @Override
    public void sendEmailVerifiedMessage(User user) {
        UserRegistrationEvent event = new UserRegistrationEvent(user.getFullName(), user.getEmail());
        eventPublisher.publishEvent(emailVerificationExchange, emailVerificationRk, event);
    }
}
