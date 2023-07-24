package com.example.initial.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // TODO: we need to talk about that class: "Important Eva" thread
    @Bean
    public Queue userRegistrationQueue() {
        return new Queue("user-registration-queue");
    }

    @Bean
    public Queue varifiedEmailQueue() {
        return new Queue("email-verification-queue");
    }

    @Bean
    public Exchange userRegistrationExchange() {
        return new DirectExchange("user-registration-exchange");
    }

    @Bean
    public Exchange emailVerificationExchange() {
        return new DirectExchange("email-verification-exchange");
    }

    @Bean
    public Binding userRegistrationBinding(Queue userRegistrationQueue, Exchange userRegistrationExchange) {
        return BindingBuilder
                .bind(userRegistrationQueue)
                .to(userRegistrationExchange)
                .with("user-registration-key")
                .noargs();
    }

    @Bean
    public Binding emailVerificationBinding(Queue varifiedEmailQueue, Exchange emailVerificationExchange) {
        return BindingBuilder
                .bind(varifiedEmailQueue)
                .to(emailVerificationExchange)
                .with("email-verification-key")
                .noargs();
    }
}



