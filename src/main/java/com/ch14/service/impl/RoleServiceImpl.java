package com.ch14.service.impl;

import ch10.pojo.Role;
import com.ch14.mapper.RoleMapper;
import com.ch14.pojo.RoleParams;
import com.ch14.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper = null;

    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, timeout = 3)
    @Override
    public int insertRole(Role role) {
        return roleMapper.insertRole(role);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, timeout = 3)
    @Override
    public int deleteById(long id) {
        return roleMapper.deleteById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, timeout = 3)
    @Override
    public void update(Role role) {
        roleMapper.update(role);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, timeout = 3)
    @Override
    public Role getById(long id) {
        return roleMapper.getById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, timeout = 3)
    @Override
    public List<Role> findRoles(RoleParams roleParams) {
        return roleMapper.findRoles(roleParams);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, timeout = 3)
    @Override
    public int insertRoles(List<Role> roles) {
        int result = 0;
        for(int i = 0; i < roles.size(); i++){
            result += roleMapper.insertRole(roles.get(i));
        }
        return result;
    }
}
