package com.example.initial.service;

import com.example.initial.entity.User;

public interface UserService {

    User findByUserName(String userName);

    User findByEmail(String email);
}
