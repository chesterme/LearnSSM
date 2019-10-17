package ch13.service;

import ch10.pojo.Role;
import org.springframework.stereotype.Component;

//@Component
public interface RoleService {
    int insertRole(Role role);
    void deleteById(long id);
    void update(Role role);
    Role getById(long id);
}
