package com.example.initial.service;

import com.example.initial.entity.User;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@AllArgsConstructor
public class MailSender {

    private JavaMailSender mailSender;
    private TemplateEngine templateEngine;

    public void sendEmail(User user) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, "UTF-8");

        Context context = new Context();
        context.setVariable("userName", user.getUserName());

        String html = templateEngine.process("email-template", context);

        helper.setTo(user.getEmail());
        helper.setText(html, true);
        helper.setSubject(user.getSubject());
        helper.setFrom("user.service.autogenerated@gmail.com");
        mailSender.send(message);
    }
}
