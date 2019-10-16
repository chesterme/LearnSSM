package ch12.main;

import ch10.pojo.Role;
import ch12.mapper.RoleMapper;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMapperFactoryBean {

    public static Logger logger = Logger.getLogger(TestMapperFactoryBean.class);

    public static void main(String[] args){

        ApplicationContext act = new ClassPathXmlApplicationContext("ch12/beans/Bean.xml");
        RoleMapper roleMapper = act.getBean(RoleMapper.class);

        Role role = new Role();
        role.setRoleName("role_name_mapperFactoryBean");
        role.setNote("note_mapperFactoryBean");
        roleMapper.insertRole(role);

        Long id = role.getId();
        role = roleMapper.getRole(id);
        System.out.println(role);

        role.setNote("note_update_mapperFactoryBean");
        roleMapper.updateRole(role);

        role = roleMapper.getRole(role.getId());
        System.out.println(role);

        id = role.getId();
        roleMapper.deleteRole(id);

    }

}
