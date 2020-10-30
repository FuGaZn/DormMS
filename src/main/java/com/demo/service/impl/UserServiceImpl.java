package com.demo.service.impl;

import com.demo.dao.UserDao;
import com.demo.dao.impl.UserDaoImpl;
import com.demo.model.Access;
import com.demo.model.Role;
import com.demo.model.User;
import com.demo.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public User getUser(String name) {
        return userDao.findByName(name);
    }

    @Override
    public boolean giveRole(int uid, int rid) {
        return false;
    }

    @Override
    public List<Role> getAllRoles(int uid) {
        return null;
    }

    @Override
    public boolean removeRole(int uid, int rid) {
        return false;
    }

    @Override
    public User addUser(User user) {
        return userDao.createUser(user);
    }

    @Override
    public List<Access> getAllAccesses(int uid) {
        return null;
    }
}
