package com.example.initial.service.impl;

import com.example.initial.entity.User;
import com.example.initial.repository.UserRepository;
import com.example.initial.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public User findByToken(String token) {
        return userRepository.findByToken(token);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
