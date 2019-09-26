package ch03.mapper;

import ch03.pojo.Role;

import java.util.List;
import java.util.Map;

public interface RoleMapper {
    /**
     * 从Role表中根据id选择对应的Role
     * @param id
     * @return
     */
    Role getRole(Long id);

    /**
     * 往Role表中插入一条记录
     * @param role
     * @return
     */
    int insertRole(Role role);

    /**
     * 根据id从Role表中删除一条记录
     * @param id
     * @return
     */
    int deleteRole(Long id);

    /**
     * 根据role对象从Role表中更新一条记录
     * @param role
     * @return
     */
    int updateRole(Role role);

    /**
     * 从Role表中查找所有同名的记录
     * @param roleName
     * @return
     */
    List<Role> findRoles(String roleName);

    /**
     * 可以通过多个参数进行查询
     * @param parameterMap
     * @return
     */
    List<Role> findRolesByMap(Map<String, Object> parameterMap);
}
