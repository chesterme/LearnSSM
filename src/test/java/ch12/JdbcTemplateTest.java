package ch12;

import ch10.pojo.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplateTest {

    public static void main(String[] args){

        ApplicationContext act = new ClassPathXmlApplicationContext("ch12/beans/bean.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) act.getBean("jdbcTemplate");
        Long id = 1L;
        String sql = "select id, role_name, note from t_role where id = " + id;
        Role role = jdbcTemplate.queryForObject(sql, new RowMapper<Role>() {
            @Override
            public Role mapRow(ResultSet resultSet, int i) throws SQLException {
                Role role = new Role();
                role.setId(resultSet.getLong(1));
                role.setRoleName(resultSet.getString(2));
                role.setNote(resultSet.getString(3));
                return role;
            }
        });
        System.out.println(role);

    }

}
