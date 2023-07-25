package com.example.initial.controller;

import com.example.initial.entity.User;
import com.example.initial.service.RegistrationService;
import com.example.initial.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final RegistrationService registrationService;

    @GetMapping("/verify/{token}")
    public ResponseEntity<String> validateUserToken(@PathVariable("token") String token) {
        User foundUser = userService.findByToken(token);
        if (foundUser != null) {
            foundUser.setIsVerified(true);
            userService.save(foundUser);
            registrationService.sendEmailVerifiedMessage(foundUser);
            return ResponseEntity.ok("Email verified successfully");
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Invalid token");
    }
}