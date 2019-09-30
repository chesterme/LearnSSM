package ch11.game;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBeanUtil implements InvocationHandler {

    private Object obj; // 被代理的对象
    private Interceptor interceptor = null; // 拦截器

    /**
     * 获取动态代理对象
     * @param obj 被代理对象
     * @param interceptor 拦截器
     * @return 动态代理对象
     */
    public static Object getBean(Object obj, Interceptor interceptor){
        ProxyBeanUtil _this = new ProxyBeanUtil();
        _this.obj = obj;
        _this.interceptor = interceptor;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), _this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        Object retObj = null;
        boolean exceptionFlag = false;
        // before方法
        interceptor.before(obj);
        try{
            // 反射原有方法
            retObj = method.invoke(obj, args);
        }catch(Exception e){
            exceptionFlag = true;
        }finally{
            interceptor.after(obj);
        }
        if(exceptionFlag){
            interceptor.afterThrowing(obj);
        }else{
            interceptor.afterReturning(obj);
        }
        return retObj;
    }

}
