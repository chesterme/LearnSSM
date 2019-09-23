package ch02;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectServiceImplTest {

    public ReflectServiceImpl getInstance(){
        ReflectServiceImpl obj = null;
        try{
            // 使用类加载器注册一个类，并使用newInstance方法实例化一个类对象
            obj = (ReflectServiceImpl)Class.forName("ch02.ReflectServiceImpl").newInstance();
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
        return obj;
    }

    public Object reflectMethod(){
        Object returnObj = null;
        ReflectServiceImpl target = new ReflectServiceImpl();
        try{
            Method method = ReflectServiceImpl.class.getMethod("sayHello", String.class);
            returnObj = method.invoke(target, "张三");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return returnObj;
    }

    public static void main(String[] args){
        ReflectServiceImplTest test = new ReflectServiceImplTest();
        ReflectServiceImpl instance = test.getInstance();
        instance.sayHello("张三");
        test.reflectMethod();
    }

}
