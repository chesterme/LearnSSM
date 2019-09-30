package ch12.main;

import ch10.pojo.Role;
import ch12.service.impl.RoleServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class Main {

    public static void main(String[] args){

        ApplicationContext act = new ClassPathXmlApplicationContext("ch12/beans/Bean.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) act.getBean("jdbcTemplate");
        RoleServiceImpl roleService = new RoleServiceImpl(jdbcTemplate);
        Role role = new Role("丐帮帮主", "江湖九大掌门之一");
        roleService.insertRole(role);
        role = new Role("丐帮长老", "江湖一流高手");
        roleService.insertRole(role);
        roleService.deleteRole(2l);
        List<Role> list = roleService.findRole("丐");
        for(Role item : list){
            System.out.println(item);
        }
        role = new Role("独孤求败", "高处不胜寒");
        roleService.updateRole(role, 1);
    }

}
