package ch02;

public class InterceptorJdkProxyTest {

    public static void main(String[] args){

        HelloWorld proxy = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(),
                "ch02.MyInterceptor");
        proxy.sayHelloWorld();

    }

}
