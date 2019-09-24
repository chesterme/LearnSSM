package ch02;

public class CglibProxyExampleTest {

    public static void main(String[] args){

        CglibProxyExample cpe = new CglibProxyExample();
        ReflectServiceImpl obj = (ReflectServiceImpl) cpe.getProxy(ReflectServiceImpl.class);
        obj.sayHello("张三");
    }

}
