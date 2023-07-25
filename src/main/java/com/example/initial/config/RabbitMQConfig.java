package com.example.initial.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
@RequiredArgsConstructor
public class RabbitMQConfig {

    @Value("${rabbitmq.queues.user-registration-q}")
    private String userRegistrationQ;

    @Value("${rabbitmq.queues.email-verification-q}")
    private String emailVerificationQ;

    @Value("${rabbitmq.exchanges.user-registration-ex}")
    private String userRegistrationEx;

    @Value("${rabbitmq.exchanges.email-verification-ex}")
    private String emailVerificationEx;

    @Value("${rabbitmq.routing-keys.user-registration-rk}")
    private String userRegistrationRoutingKey;

    @Value("${rabbitmq.routing-keys.email-verification-rk}")
    private String getEmailVerificationRoutingKey;

    @Bean
    public Queue userRegistrationQueue() {
        return new Queue(userRegistrationQ);
    }

    @Bean
    public Queue varifiedEmailQueue() {
        return new Queue(emailVerificationQ);
    }

    @Bean
    public Exchange userRegistrationExchange() {
        return new DirectExchange(userRegistrationEx);
    }

    @Bean
    public Exchange emailVerificationExchange() {
        return new DirectExchange(emailVerificationEx);
    }

    @Bean
    public Binding userRegistrationBinding(Queue userRegistrationQueue, Exchange userRegistrationExchange) {
        return BindingBuilder
                .bind(userRegistrationQueue)
                .to(userRegistrationExchange)
                .with(userRegistrationRoutingKey)
                .noargs();
    }

    @Bean
    public Binding emailVerificationBinding(Queue varifiedEmailQueue, Exchange emailVerificationExchange) {
        return BindingBuilder
                .bind(varifiedEmailQueue)
                .to(emailVerificationExchange)
                .with(getEmailVerificationRoutingKey)
                .noargs();
    }
}



