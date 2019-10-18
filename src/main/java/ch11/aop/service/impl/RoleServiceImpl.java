package ch11.aop.service.impl;

import ch10.pojo.Role;
import ch10.pojo.Role;
import ch11.aop.service.RoleService;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceImpl implements RoleService {

    @Override
    public void printRole(Role role) {
        System.out.println(role);
    }

}
