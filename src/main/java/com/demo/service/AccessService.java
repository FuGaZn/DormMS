package com.demo.service;

import com.demo.model.Access;

public interface AccessService {
    boolean addAccess(Access access);

    boolean deleteAccess(int aid);
}
