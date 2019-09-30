package ch11.game.service.impl;

import ch10.pojo.Role;
import ch11.game.service.RoleService;

public class RoleServiceImpl implements RoleService {

    @Override
    public void printRole(Role role) {
        System.out.println(role);
    }
}
