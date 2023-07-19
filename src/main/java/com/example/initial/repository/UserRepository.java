package com.example.initial.repository;

import com.example.initial.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    User findByEmail(String email);
}
