package com.example.initial.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
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

    @Size(min = 2, max = 50)
    @NotBlank
    @Column(name = "user_name")
    private String userName;

    @Email(message = "Invalid email format")
    @Column(name = "email")
    private String email;

    @Column(name = "token")
    private String token;

    @Column(name = "verified")
    private Boolean isVerified;

    @Builder.Default
    @Column(name = "subject")
    private String subject = "UserA support";


}
