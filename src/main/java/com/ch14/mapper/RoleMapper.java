package com.ch14.mapper;

import ch10.pojo.Role;
import com.ch14.pojo.RoleParams;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component("roleMapper")
@Repository
public interface RoleMapper {
    int insertRole(Role role);
    void deleteById(long id);
    void update(Role role);
    Role getById(long id);
    List<Role> findRoles(RoleParams roleParams);
}
