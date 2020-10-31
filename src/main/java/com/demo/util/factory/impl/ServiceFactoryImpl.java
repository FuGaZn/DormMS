package com.demo.util.factory.impl;

import com.demo.service.AccessService;
import com.demo.service.RoleService;
import com.demo.service.UserService;
import com.demo.service.impl.AccessServiceImpl;
import com.demo.service.impl.RoleServiceImpl;
import com.demo.service.impl.UserServiceImpl;
import com.demo.util.factory.ServiceFactory;

public class ServiceFactoryImpl implements ServiceFactory {
    UserService userService = new UserServiceImpl();
    RoleService roleService = new RoleServiceImpl();
    AccessService accessService = new AccessServiceImpl();
    @Override
    public UserService getUserService() {
        return userService;
    }

    @Override
    public RoleService getRoleService() {
        return roleService;
    }

    @Override
    public AccessService getAccessService() {
        return accessService;
    }
}
