package ch03.mapper;

import ch03.pojo.Role;

public interface RoleMapper {
    /**
     * 从Role表中根据id选择对应的Role
     * @param id
     * @return
     */
    Role getRole(Long id);
}
