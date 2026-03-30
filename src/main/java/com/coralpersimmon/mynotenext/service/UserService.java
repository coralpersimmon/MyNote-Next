package com.coralpersimmon.mynotenext.service;

import com.coralpersimmon.mynotenext.dto.UserRegisterRequest;
import com.coralpersimmon.mynotenext.model.User;

public interface UserService {
    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);
}
