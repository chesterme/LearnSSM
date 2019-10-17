package ch13.main;

import ch10.pojo.Role;
import ch13.service.RoleListService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestTransaction {

    private static Logger logger = Logger.getLogger(TestTransaction.class);

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("ch13/config/spring-config.xml");
        RoleListService roleListService = context.getBean(RoleListService.class);
        List<Role> roleList = new ArrayList<>();
        for(int i = 1; i <= 3; i++){
            Role role = new Role();
            role.setRoleName("role_name_" + i);
            role.setNote("note_" + i);
            roleList.add(role);
        }
        int count = roleListService.insertRoleList(roleList);
        System.out.println(count);

        List<Long> intList = new ArrayList<>();
        for(Role role : roleList){
            intList.add(role.getId());
        }

        System.out.println("after insert: ");
        roleList = roleListService.selectRoleList(intList);
        for(int i = 0; i < roleList.size(); i++){
            System.out.println(roleList.get(i));
            roleList.get(i).setNote("note_update_" + i);
            roleList.get(i).setRoleName("name_update_" + i);
        }
        System.out.println("+++++++++++++++++++++");

        System.out.println("after update: ");
        roleListService.updateRoleList(roleList);
        roleList = roleListService.selectRoleList(intList);
        for(Role role : roleList){
            System.out.println(role);
        }
        System.out.println("+++++++++++++++++++++");

        System.out.println("after delete: ");
        System.out.println(roleListService.deleteRoleList(roleList));
    }

}
