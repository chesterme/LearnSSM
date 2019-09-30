package ch10.service.impl;

import ch10.pojo.Role;
import ch10.service.RoleService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("RoleService2")
public class RoleServiceImpl2 implements RoleService2 {

    @Autowired
    private Role role = null;

    @Override
    public void printRoleInfo() {
        System.out.println(role);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
