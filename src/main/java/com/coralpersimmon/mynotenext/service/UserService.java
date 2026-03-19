package com.coralpersimmon.mynotenext.service;

import com.coralpersimmon.mynotenext.dao.UserRepository;
import com.coralpersimmon.mynotenext.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(int userId) {
        return userRepository.findById(userId).get();
    }
}
