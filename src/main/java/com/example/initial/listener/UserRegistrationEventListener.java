package com.example.initial.listener;

import com.example.initial.entity.User;
import com.example.initial.event.UserRegistrationEvent;
import com.example.initial.repository.UserRepository;
import com.example.initial.service.GmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Component
@RequiredArgsConstructor
public class UserRegistrationEventListener {

    private final UserRepository userRepository;
    private final GmailService gmailService;

    @RabbitListener(queues = "user-registration-queue")
    public void onUserRegistrationEvent(UserRegistrationEvent event) throws MessagingException, GeneralSecurityException, IOException {
        User user = User.builder()
                .userName(event.getUserName())
                .email(event.getEmail())
                .build();
        userRepository.save(user);
        gmailService.sendEmail(user);
    }
}
