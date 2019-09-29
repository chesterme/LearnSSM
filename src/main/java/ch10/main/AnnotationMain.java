package ch10.main;

import ch10.pojo.Book;
import ch10.pojo.PojoConfig;
import ch10.pojo.Role;
import ch10.service.RoleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationMain {

    public static void main(String[] args){

        ApplicationContext act = new AnnotationConfigApplicationContext(PojoConfig.class);
        Book book = act.getBean(Book.class);
        System.out.println(book);
        Role role = act.getBean(Role.class);
        RoleService roleService = act.getBean(RoleService.class);
        roleService.printRoleInfo(role);
    }

}
