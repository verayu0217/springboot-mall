package com.vera.springbootmall.dao;

import com.vera.springbootmall.dto.UserRegisterRequest;
import com.vera.springbootmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);
    User getUserByEmail(String email);
    Integer createUser(UserRegisterRequest userRegisterRequest);
}