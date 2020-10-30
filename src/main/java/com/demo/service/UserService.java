package com.demo.service;

import com.demo.model.User;

public interface UserService {
    User login(String name, String password);
}
