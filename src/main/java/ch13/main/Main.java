package ch13.main;

import ch10.pojo.Role;
import ch13.service.PersonService;
import ch13.service.PrintService;
import ch13.service.RoleService;
import ch13.service.impl.PersonServiceImpl;
import ch13.service.impl.PrintServiceImpl;
import ch13.service.impl.RoleServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("ch13/config/spring-config.xml");

        PersonService personService = context.getBean(PersonService.class);
        personService.print();

        PrintService printService = context.getBean(PrintService.class);
        printService.print();

        RoleService roleService = context.getBean(RoleService.class);
        Role role = new Role("name_test", "note_test");
        roleService.insertRole(role);
        System.out.println("after insert: " + role);

        role.setNote("note_test_update");
        role.setRoleName("name_test_update");
        roleService.update(role);


        role = roleService.getById(role.getId());
        System.out.println("after update: " + role);

        roleService.deleteById(role.getId());

    }

}
