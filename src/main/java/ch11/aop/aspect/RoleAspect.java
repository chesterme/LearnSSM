package ch11.aop.aspect;

import org.aspectj.lang.annotation.*;

@Aspect
public class RoleAspect {

    @Pointcut("execution(* ch11.aop.service.impl.RoleServiceImpl.printRole(..))")
    public void print(){}

    @Before("print()")
    public void before(){
        System.out.println("before ...");
    }

    @After("print()")
    public void after(){
        System.out.println("after ...");
    }

    @AfterThrowing("execution(* ch11.aop.service.impl.RoleServiceImpl.printRole(..))")
    public void afterThrowing(){
        System.out.println("afterThrowing ...");
    }

    @AfterReturning("execution(* ch11.aop.service.impl.RoleServiceImpl.printRole(..))")
    public void afterReturn(){
        System.out.println("afterReturning ...");
    }

}
