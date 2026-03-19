package com.coralpersimmon.mynotenext.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    Integer userId;

    @Column(name = "account")
    String account;

    @Column(name = "password")
    String password;

    @Column(name = "userName")
    String userName;

    @Column(name = "email")
    String email;
}
