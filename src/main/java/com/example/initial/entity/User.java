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
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 50)
    @NotBlank
    @Column(name = "user_name")
    private String userName;

    @Email(message = "Invalid email format")
    @Column(name = "email")
    private String email;

    //The default subject will be "UserA support" unless subject is explicitly set
//    @Builder.Default
    @Column(name = "subject")
    private String subject = "UserA support";
}
