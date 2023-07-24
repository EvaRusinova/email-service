//package com.example.initial.config;
//
//import com.google.api.client.http.javanet.NetHttpTransport;
//import com.google.auth.http.HttpTransportFactory;
//import com.google.auth.oauth2.UserCredentials;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.stereotype.Component;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//
//import java.io.IOException;
//import java.util.Properties;
//
//@Component
//@Configuration
//public class MailConfiguration {
//
//    @Value("${mail.host}")
//    private String host;
//
//    @Value("${mail.port}")
//    private int port;
//
//    @Value("${mail.username}")
//    private String username;
//
//    @Value("${mail.password}")
//    private String password;
//
//    @Value("${mail.properties.protocol}")
//    private String protocol;
//
//    @Value("${mail.properties.auth}")
//    private String smtpAuth;
//
//    @Value("${mail.properties.starttls}")
//    private String starttls;
//
//    @Value("${mail.properties.debug}")
//    private String debug;
//
//    @Value("${mail.oauth.clientId}")
//    private String clientId;
//
//    @Value("${mail.oauth.clientSecret}")
//    private String clientSecret;
//
//    @Value("${mail.oauth.refreshToken}")
//    private String refreshToken;
//
//    @Bean
//    public SpringTemplateEngine springTemplateEngine() {
//        return new SpringTemplateEngine();
//    }
//
//    @Bean
//    public JavaMailSenderImpl getJavaMailSender() {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost(host);
//        mailSender.setPort(port);
//
//        mailSender.setUsername(username);
//        mailSender.setPassword(password);
//
//        Properties props = mailSender.getJavaMailProperties();
//        props.put("mail.transport.protocol", protocol);
//        props.put("mail.smtp.auth", smtpAuth);
//        props.put("mail.smtp.starttls.enable", starttls);
//        props.put("mail.debug", debug);
//        mailSender.setJavaMailProperties(props);
//
//        try {
//            HttpTransportFactory httpTransportFactory = NetHttpTransport::new;
//            UserCredentials credentials = UserCredentials.newBuilder()
//                    .setClientId(clientId)
//                    .setClientSecret(clientSecret)
//                    .setRefreshToken(refreshToken)
//                    .setHttpTransportFactory(httpTransportFactory)
//                    .build();
//
//            mailSender.setUsername(username);
//            mailSender.setPassword(credentials.refreshAccessToken().getTokenValue());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return mailSender;
//    }
//
//}
