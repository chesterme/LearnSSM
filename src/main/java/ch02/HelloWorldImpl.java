package ch02;

public class HelloWorldImpl implements HelloWorld, BeforeAfter {

    @Override
    public void sayHelloWorld() {
        System.out.println("hello world");
    }

    @Override
    public void before() {
        System.out.println("do something before saying hello world");
    }

    @Override
    public void after() {
        System.out.println("do something after saying hello world");
    }
}
