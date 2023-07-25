package com.example.initial.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Email(message = "Invalid email format")
    @Column(name = "email")
    private String email;

    @Column(name = "token")
    private String token;

    @Column(name = "is_verified")
    private Boolean isVerified;

}
