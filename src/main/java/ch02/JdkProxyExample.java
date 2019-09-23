package ch02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyExample<T extends BeforeAfter> implements InvocationHandler {

    // 真实对象
    private T target = null;

    /**
     * 代理方法逻辑
     * @param proxy 代理对象
     * @param method 当前调度方法
     * @param args 当前方法参数
     * @return 代理结果返回
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(target, args);
        after();
        return obj;
    }

    /**
     * 建立代理对象和真实对象之间的代理关系，返回代理对象
     * @param target 真实对象
     * @return 代理对象
     */
    public Object bind(T target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    public void before(){
        System.out.println("在调度真实对象之前");
        target.before();
    }

    public void after(){
        System.out.println("在调度真实对象之后");
        target.after();
    }
}
