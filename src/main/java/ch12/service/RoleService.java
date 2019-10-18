package ch12.service;

import ch10.pojo.Role;
import ch10.pojo.Role;

import java.util.List;

public interface RoleService {

    int insertRole(Role role);
    int deleteRole(long id);
    int updateRole(Role role, long id);
    List<Role> findRole(String roleName);

}
