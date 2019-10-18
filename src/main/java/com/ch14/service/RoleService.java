package com.ch14.service;

import ch10.pojo.Role;

public interface RoleService {
    int insertRole(Role role);
    void deleteById(long id);
    void update(Role role);
    Role getById(long id);
}
