package com.example.initial.listener;

import com.example.initial.entity.User;
import com.example.initial.event.UserRegistrationEvent;
import com.example.initial.messaging.EventPublisher;
import com.example.initial.repository.UserRepository;
import com.example.initial.service.MailSender;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRegistrationEventListener {

    private final UserRepository userRepository;
    private final EventPublisher eventPublisher;
    private final MailSender mailSender;

    @RabbitListener(queues = "user-registration-queue")
    public void onUserRegistrationEvent(UserRegistrationEvent event) throws MessagingException {
        User user = User.builder()
                .userName(event.getUserName())
                .email(event.getEmail())
                .build();
        userRepository.save(user);
        try {
            mailSender.sendEmail(user);
        } catch (MessagingException e) {
            // handle the exception
        }
        eventPublisher.publishEvent("email-verification-exchange", "email-verification-key", event);
    }
}
