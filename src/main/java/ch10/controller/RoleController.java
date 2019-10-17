package ch10.controller;

import ch10.pojo.Role;
import ch10.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RoleController {

    @Autowired
    @Qualifier("roleServiceImpl3")
    private RoleService roleService = null;

    public void printRole(Role role){
        roleService.printRoleInfo(role);
    }

}
