package com.demo.util.factory;

import com.demo.service.AccessService;
import com.demo.service.RoleService;
import com.demo.service.UserService;

public interface ServiceFactory {
    UserService getUserService();
    RoleService getRoleService();
    AccessService getAccessService();
}
