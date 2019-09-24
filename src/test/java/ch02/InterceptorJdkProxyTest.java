package ch02;

public class InterceptorJdkProxyTest {

    public static void main(String[] args){

//        HelloWorld proxy = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(),
//                "ch02.MyInterceptor");
//        proxy.sayHelloWorld();

        HelloWorld proxy1 = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(),
                "ch02.Interceptor1");
        HelloWorld proxy2 = (HelloWorld) InterceptorJdkProxy.bind(proxy1,
                "ch02.Interceptor2");
        HelloWorld proxy3 = (HelloWorld) InterceptorJdkProxy.bind(proxy2,
                "ch02.Interceptor3");
        proxy3.sayHelloWorld();
    }

}
