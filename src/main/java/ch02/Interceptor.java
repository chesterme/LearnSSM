package ch02;

import java.lang.reflect.Method;

public interface Interceptor {

    /**
     * 在真实对象调用之前调用
     * @param proxy 代理对象
     * @param target 真实对象
     * @param method 被调用的方法
     * @param args 方法参数
     * @return 当返回true时，则反射真实对象的方法；当返回false时，则调用around方法
     */
    boolean before(Object proxy, Object target, Method method, Object[] args);

    /**
     * 在before方法返回false时调用
     * @param proxy 代理对象
     * @param target 真实对象
     * @param method 被调用的方法
     * @param args 方法参数
     * @return
     */
    void around(Object proxy, Object target, Method method, Object[] args);

    /**
     * 在反射真实对象方法或者around方法执行之后调用
     * @param proxy 代理对象
     * @param target 真实对象
     * @param method 被调用的方法
     * @param args 方法参数
     * @return
     */
    void after(Object proxy, Object target, Method method, Object[] args);
}
