package ch12.mapper;

import ch10.pojo.Role;
import ch05.bean.PageParams;
import ch05.bean.RoleParams;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository // 表示DAO层
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

    List<Role> findRolesByAnnotation(@Param("roleName") String roleName, @Param("note") String note);

    List<Role> findRolesByBean(RoleParams roleParams);

    List<Role> findByMix(@Param("params") RoleParams roleParams, @Param("page") PageParams pageParams);

    List<Role> findByRowBounds(@Param("note") String note, RowBounds rowBounds);
}
