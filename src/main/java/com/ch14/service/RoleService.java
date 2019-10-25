package com.ch14.service;

import ch10.pojo.Role;
import com.ch14.pojo.RoleParams;

import java.util.List;

public interface RoleService {
    int insertRole(Role role);
    int deleteById(long id);
    void update(Role role);
    Role getById(long id);
    List<Role> findRoles(RoleParams roleParams);
    int insertRoles(List<Role> roles);
}
