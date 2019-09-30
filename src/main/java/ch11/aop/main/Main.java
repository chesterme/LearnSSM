package ch11.aop.main;

import ch10.pojo.Role;
import ch11.aop.config.AopConfig;
import ch11.aop.service.RoleService;
import ch11.game.service.impl.RoleServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args){

        // 通过注解来生成ApplicationContext对象
        ApplicationContext act = new AnnotationConfigApplicationContext(AopConfig.class);
        RoleService roleService = (RoleService) act.getBean(RoleService.class);
        Role role = new Role(1L, "role_name_1", "note_1");
        roleService.printRole(role);
        System.out.println("++++++++++++++++ 测试异常情况 +++++++++++++++");
        role = null;
        roleService.printRole(role);
    }

}
