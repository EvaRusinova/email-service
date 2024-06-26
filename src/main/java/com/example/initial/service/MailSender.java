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

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class MailSender {

    private JavaMailSender mailSender;
    private TemplateEngine templateEngine;

    public void sendEmail(User user) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, "UTF-8");

        Map<String, Object> model = new HashMap<>();
        model.put("token", user.getToken());
        model.put("fullName", user.getFullName());

        Context context = new Context();
        context.setVariables(model);

        String html = templateEngine.process("email-template", context);

        helper.setTo(user.getEmail());
        helper.setText(html, true);
        helper.setSubject("Confirm  your email");
        helper.setFrom("user.service.autogenerated@gmail.com");
        mailSender.send(message);
    }
}
