package com.coralpersimmon.mynotenext.service.impl;

import com.coralpersimmon.mynotenext.dao.UserRepository;
import com.coralpersimmon.mynotenext.dto.UserRegisterRequest;
import com.coralpersimmon.mynotenext.model.User;
import com.coralpersimmon.mynotenext.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        User user = new User();
        user.setAccount(userRegisterRequest.getAccount());
        user.setPassword(userRegisterRequest.getPassword());

        User savedUser = userRepository.save(user);
        return savedUser.getUserId();
    }
}
