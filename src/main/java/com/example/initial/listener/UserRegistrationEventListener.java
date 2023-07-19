package com.example.initial.listener;

import com.example.initial.entity.User;
import com.example.initial.event.UserRegistrationEvent;
import com.example.initial.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRegistrationEventListener {

    private final UserRepository userRepository;

    @RabbitListener(queues = "user-registration-queue")
    public void onUserRegistrationEvent(UserRegistrationEvent event) {
        User user = User.builder()
                .userName(event.getUserName())
                .email(event.getEmail())
                .build();
        userRepository.save(user);

        // Handle the user registration event
    }
}
