package ch10.service;

import ch10.pojo.Role;
import ch10.pojo.Role;
import org.springframework.stereotype.Component;

@Component
public interface RoleService {
    void printRoleInfo(Role role);
}
