package com.example.initial;

import com.example.initial.entity.User;
import com.example.initial.repository.UserRepository;
import com.example.initial.service.MailSender;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
@RequiredArgsConstructor
public class EmailServiceApplication implements ApplicationRunner {

    private final UserRepository userRepository;
    private final MailSender mailSender;

    public static void main(String[] args) {
        SpringApplication.run(EmailServiceApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = User.builder()
                .userName("antoanr")
                .fullName("Antoan Rusinov")
                .email("antoan.rusinov@gmail.com")
                .token(UUID.randomUUID().toString())
                .build();
        userRepository.save(user);
        mailSender.sendEmail(user);
    }
}
