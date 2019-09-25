package ch03.mapper;

import ch03.pojo.Role;
import org.apache.ibatis.annotations.Select;

public interface RoleMapper2 {
    @Select("select id, role_name as roleName, note from t_role where id = #{id}")
    Role getRle(Long id);
}
