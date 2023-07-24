//package com.example.initial.service;
//
//import com.example.initial.entity.User;
//import lombok.RequiredArgsConstructor;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.stereotype.Service;
//import org.thymeleaf.context.Context;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//
//@Service
//@RequiredArgsConstructor
//public class MailSender {
//
//    private final JavaMailSenderImpl mailSender;
//    private final SpringTemplateEngine templateEngine;
//
//    public void sendEmail(User user) {
//        String content = getMailContent(user.getUserName());
//        SimpleMailMessage message = new SimpleMailMessage();
//
//        message.setFrom(mailSender.getUsername());
//        message.setTo(user.getEmail());
//        message.setSubject("Your Subject Here");
//        message.setText(content);
//
//        mailSender.send(message);
//    }
//
//    private String getMailContent(String userName) {
//        Context context = new Context();
//        context.setVariable("userName", userName);
//        return templateEngine.process("email-template.html", context);
//    }
//}
