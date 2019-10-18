package ch10.service.impl;

import ch10.pojo.Role;
import ch10.pojo.Role;
import ch10.service.RoleService;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceImpl implements RoleService {

    @Override
    public void printRoleInfo(Role role) {
        System.out.println(role);
    }
}
