package com.example.initial.controller;

import com.example.initial.entity.User;
import com.example.initial.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/verify/{token}")
    public ResponseEntity<String> verifyUser(@PathVariable("token") String token) {
        User user = userService.findByToken(token);
        if (user != null) {
            user.setIsVerified(true);
            user.setToken(null);
            userService.save(user);
            return ResponseEntity.ok("Email verified successfully");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid token");
    }
}