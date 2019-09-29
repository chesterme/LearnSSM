package ch10;

import ch10.pojo.ComplexAssembly;
import ch10.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserTest {

    public static void main(String[] args){

        ApplicationContext act = new ClassPathXmlApplicationContext("ch10/config/Beans.xml");
        User user = (User) act.getBean("user1");
        System.out.println(user);

        ComplexAssembly complexAssembly = (ComplexAssembly) act.getBean("complexAssembly");
        System.out.println(complexAssembly);

    }

}
