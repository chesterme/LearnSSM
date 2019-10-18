package ch12.service.impl;

import ch10.pojo.Role;
import ch10.pojo.Role;
import ch12.service.RoleService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RoleServiceImpl  implements RoleService {

    private JdbcTemplate jdbcTemplate;

    public RoleServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public RoleServiceImpl() {
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertRole(Role role) {
        String sql = "insert into t_role(role_name, note) values(?, ?)";
        return jdbcTemplate.update(sql, role.getRoleName(), role.getNote());
    }

    @Override
    public int deleteRole(long id) {
        String sql = "delete from t_role where id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateRole(Role role, long id) {
        String sql = "update t_role set role_name=?, note=? where id=?";
        return jdbcTemplate.update(sql, role.getRoleName(), role.getNote(), id);
    }

    @Override
    public List<Role> findRole(String roleName) {
        String sql = "select id, role_name, note from t_role where role_name like concat('%',?,'%')";
        Object[] params = {roleName};
        List<Role> list = jdbcTemplate.query(sql, params, new RowMapper<Role>() {
            @Override
            public Role mapRow(ResultSet resultSet, int i) throws SQLException {
                Role role = new Role();
                role.setId(resultSet.getLong(1));
                role.setRoleName(resultSet.getString(2));
                role.setNote(resultSet.getString(3));
                return role;
            }
        });
        return list;
    }
}
