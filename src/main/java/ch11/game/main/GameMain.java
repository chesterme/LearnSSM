package ch11.game.main;

import ch10.pojo.Role;
import ch11.game.Interceptor;
import ch11.game.ProxyBeanUtil;
import ch11.game.interceptor.RoleInterceptor;
import ch11.game.service.RoleService;
import ch11.game.service.impl.RoleServiceImpl;

public class GameMain {

    public static void main(String[] args){

        RoleService roleService = new RoleServiceImpl();
        Interceptor interceptor = new RoleInterceptor();
        RoleService proxy = (RoleService) ProxyBeanUtil.getBean(roleService, interceptor);
        Role role = new Role(1L, "role_name_1", "role_note_1");
        proxy.printRole(role);
        System.out.println("+++++++++++++++ 测试 afterThrowing方法 ++++++++++");
        role = null;
        proxy.printRole(role);

    }

}
