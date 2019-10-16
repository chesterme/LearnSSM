package ch12.main;

import ch10.pojo.Role;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestSqlSessionTemplate {

    public static Logger logger = Logger.getLogger(TestSqlSessionTemplate.class);

    public static void main(String[] args){

        ApplicationContext act = new ClassPathXmlApplicationContext("ch12/beans/Bean.xml");
        SqlSessionTemplate sqlSessionTemplate = act.getBean(SqlSessionTemplate.class);
        Role role = new Role();
        role.setRoleName("role_name_sqlSessionTemplate");
        role.setNote("note_sqlSessionTemplate");
        sqlSessionTemplate.insert("ch12.mapper.RoleMapper.insertRole", role);
        System.out.println(role);

        Long id = role.getId();
        sqlSessionTemplate.selectOne("ch12.mapper.RoleMapper.getRole", id);
        System.out.println(role);

        role.setNote("update_sqlSessionTemplate");
        sqlSessionTemplate.update("ch12.mapper.RoleMapper.updateRole", role);
        id = role.getId();
        role = sqlSessionTemplate.selectOne("ch12.mapper.RoleMapper.getRole", id);
        System.out.println(role);

        sqlSessionTemplate.delete("ch12.mapper.RoleMapper.deleteRole", role);
        sqlSessionTemplate.selectOne("ch12.mapper.RoleMapper.getRole", id);
    }

}
