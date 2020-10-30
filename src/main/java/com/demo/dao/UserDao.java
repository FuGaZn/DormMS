package com.demo.dao;

import com.demo.model.User;

public interface UserDao {
    User findByName(String name);
    
    User createUser(User user);
}
