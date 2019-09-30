package ch10.service.impl;

import ch10.pojo.Role;
import ch10.service.RoleService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class RoleServiceImpl3 implements RoleService {

    @Override
    public void printRoleInfo(Role role) {
        System.out.println(role);
    }
}
