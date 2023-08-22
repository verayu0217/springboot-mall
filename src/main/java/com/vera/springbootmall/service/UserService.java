package com.vera.springbootmall.service;

import com.vera.springbootmall.dto.UserLoginRequest;
import com.vera.springbootmall.dto.UserRegisterRequest;
import com.vera.springbootmall.model.User;

public interface UserService {

    User getUserById(Integer userId);
    Integer register(UserRegisterRequest userRegisterRequest);
    User login(UserLoginRequest userLoginRequest);
}
