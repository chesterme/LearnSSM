package ch11.game.interceptor;

import ch11.game.Interceptor;

public class RoleInterceptor implements Interceptor {

    @Override
    public void before(Object obj) {
        System.out.println("准备打印角色信息");
    }

    @Override
    public void after(Object obj) {
        System.out.println("已经完成打印角色信息");
    }

    @Override
    public void afterReturning(Object obj) {
        System.out.println("刚刚完成打印功能，一切正常");
    }

    @Override
    public void afterThrowing(Object obj) {
        System.out.println("打印功能异常");
    }
}
