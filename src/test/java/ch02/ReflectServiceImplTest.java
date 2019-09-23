package ch02;

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

    public static void main(String[] args){
        ReflectServiceImplTest test = new ReflectServiceImplTest();
        ReflectServiceImpl instance = test.getInstance();
        instance.sayHello("张三");
    }

}
