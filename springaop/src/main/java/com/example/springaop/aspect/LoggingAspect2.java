package com.example.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect2 {

    @Before("com.example.springaop.aspect.ApplicationPointcuts.publicServiceMethod()")
    public void logBeforeMethod(){
        System.out.println("Method intercepted");
    }

//    @Before("execution(com.example.springaop.dto.Student " +
//            "com.example.springaop.service.StudentService.createStudent(com.example.springaop.dto.Student))")
//    public void logBeforeMethod2(){
//        System.out.println("Method intercepted");
//    }
}

/*
* Some more types of designators
* @within(class level annotation) --do not intercept inherited method
*    @within(org.springframework.stereotype.Service)
*
*@target(class level annotation) --also intercepts inherited methods
*    @target(org.springframework.stereotype.Service)
*
* args(com.example.aopdemo.dto.Student) : any method which takes this argument
*           -should be used with || , &&
*
* @args(jdk.jsr.timestamps) - aisa method search kru jo ek object type ka args leta ho
*                             usme ye wala annotation lga ho
*
*
* target(com.example.aopdemo.service.studentService) -> if target obj is of studentService
*
* this(com.example.aopdemo.service.studentService) -> if this is type of studentService
*
*
*
*
* Types of proxy
*   1. CGLIB proxy (Default)
*   2. JDK dynamic proxy
*
*
*
* */
