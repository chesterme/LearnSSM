package ch13.mapper;

import ch10.pojo.Role;
import ch10.pojo.Role;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component("roleMapper")
@Repository
public interface RoleMapper {
    int insertRole(Role role);
    void deleteById(long id);
    void update(Role role);
    Role getById(long id);
}
