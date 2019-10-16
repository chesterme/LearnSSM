package ch12.main;

import ch10.pojo.Role;
import ch12.mapper.RoleMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 测试Spring和Mybatis的整合
public class TestComplex {

    public static void main(String[] args){

        ApplicationContext act = new ClassPathXmlApplicationContext("ch12/beans/Bean.xml");
        RoleMapper roleMapper = act.getBean(RoleMapper.class);
        Role role = new Role();
        role.setRoleName("role_name_mapper");
        role.setNote("note_mapper");
        roleMapper.insertRole(role);


        Long id = role.getId();
        role = roleMapper.getRole(id);
        System.out.println(role);

        role.setNote("note_update_mapper");
        roleMapper.updateRole(role);

        role = roleMapper.getRole(role.getId());
        System.out.println(role);

        roleMapper.deleteRole(role.getId());

    }

}
