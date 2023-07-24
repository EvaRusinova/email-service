package com.example.initial.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue userRegistrationQueue() {
        return new Queue("user-registration-queue");
    }

    @Bean
    public Exchange userRegistrationExchange() {
        return new DirectExchange("user-registration-exchange");
    }

    @Bean
    public Binding userRegistrationBinding(Queue userRegistrationQueue, Exchange userRegistrationExchange) {
        return BindingBuilder
                .bind(userRegistrationQueue)
                .to(userRegistrationExchange)
                .with("user-registration-key")
                .noargs();
    }
}



