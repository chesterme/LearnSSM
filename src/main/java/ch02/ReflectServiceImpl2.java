package ch02;

import java.lang.reflect.InvocationTargetException;

public class ReflectServiceImpl2 {

    private String name;

    public ReflectServiceImpl2(String name) {
        this.name = name;
    }

    public void sayHello(){
        System.err.println("hello " + name);
    }

}
