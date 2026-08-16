package com.example.springaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class ApplicationPointcuts {

    @Pointcut("within(com.example.springaop.controller..*)")
    public void controllerLayer(){
        //empty body
    }

    @Pointcut("within(com.example.springaop.service..*)")
    public void serviceLayer(){
        //empty body
    }

    @Pointcut("execution(Public * *(..))")
    public void publicMethod(){
        //empty body
    }
    @Pointcut("serviceLayer && publicMethod")
    public void publicServiceMethod(){
            //empty body
    }

    @Pointcut("execution(* *.get*())")
    public void getterMethod(){
        //empty body
    }
}
