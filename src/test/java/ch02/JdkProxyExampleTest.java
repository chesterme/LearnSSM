package ch02;

public class JdkProxyExampleTest {

    public static void main(String[] args){
        JdkProxyExample jdkProxy = new JdkProxyExample();
        HelloWorld proxy = (HelloWorld) jdkProxy.bind(new HelloWorldImpl());
        proxy.sayHelloWorld();
    }

}
