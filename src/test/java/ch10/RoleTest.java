package ch10;

import ch10.pojo.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RoleTest {

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ch10/config/Beans.xml");
        Role role = (Role) ctx.getBean("role1");
        System.out.println(role);

        role = (Role) ctx.getBean("role2");
        System.out.println(role);
    }

}
