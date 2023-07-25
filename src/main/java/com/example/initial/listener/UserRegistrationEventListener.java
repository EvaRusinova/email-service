package com.example.initial.listener;

import com.example.initial.entity.User;
import com.example.initial.event.UserRegistrationEvent;
import com.example.initial.repository.UserRepository;
import com.example.initial.service.MailSender;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserRegistrationEventListener {

    private final UserRepository userRepository;
    private final MailSender mailSender;

    @RabbitListener(queues = "user-registration-queue")
    public void onUserRegistrationEvent(UserRegistrationEvent event) throws MessagingException {
        User user = User.builder()
                .fullName(event.getFullName())
                .email(event.getEmail())
                .token(UUID.randomUUID().toString())
                .build();
        userRepository.save(user);
        mailSender.sendEmail(user);
    }
}
