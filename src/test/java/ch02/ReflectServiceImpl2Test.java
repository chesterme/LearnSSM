package ch02;

import java.lang.reflect.InvocationTargetException;

public class ReflectServiceImpl2Test {

    public ReflectServiceImpl2 getInstance(){
        ReflectServiceImpl2 obj = null;
        try{
            // 使用类加载器注册一个对象，使用getConstructor方法指定使用哪个构造函数构建对象，使用newInstance方法生成一个对象
            obj = (ReflectServiceImpl2)Class.forName("ch02.ReflectServiceImpl2").getConstructor(String.class).newInstance("张三");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static void main(String[] args){
        ReflectServiceImpl2Test test = new ReflectServiceImpl2Test();
        ReflectServiceImpl2 origin = new ReflectServiceImpl2("张三");
        origin.sayHello();
        ReflectServiceImpl2 instance = test.getInstance();
        instance.sayHello();
        System.out.println(origin);
        System.out.println(instance);
        System.out.println(origin == instance);
    }

}
