package ch02;

import java.lang.reflect.Method;

public class Interceptor3 implements Interceptor {

    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("拦截器3的before方法");
        return true;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {

    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("拦截器3的after方法");
    }
}
