package com.demo.service.impl;

import com.demo.model.Access;
import com.demo.service.AccessService;
import com.demo.util.factory.DaoFactory;
import com.demo.util.factory.impl.DaoFactoryImpl;

public class AccessServiceImpl implements AccessService {
    DaoFactory daoFactory = new DaoFactoryImpl();
    @Override
    public boolean addAccess(Access access) {
        daoFactory.getAccessDao().addAccess(access);
        return true;
    }

}
