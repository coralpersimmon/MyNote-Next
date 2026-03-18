package com.coralpersimmon.mynotenext.controller;

import com.coralpersimmon.mynotenext.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserRepository userRepository;
}
