package com.example.initial.service;

import com.example.initial.entity.User;

public interface UserService {

    User findByToken(String token);

    void save(User user);
}
