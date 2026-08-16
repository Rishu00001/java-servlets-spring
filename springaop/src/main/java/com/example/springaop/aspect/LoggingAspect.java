//package com.example.springaop.aspect;

import com.example.springaop.dto.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
//public class LoggingAspect {
//
////    @Before("execution(String com.example.springaop.service.StudentService.createStudent())")
////    public void logBeforeMethod(JoinPoint joinPoint) {
////        Object arr[] = joinPoint.getArgs();
////        System.out.println("Student is going to be saved");
////
////        boolean allowed = false;
////        if(!allowed){
////            throw new RuntimeException("Method execution not allowed");
////        }
////    }
//
////    @AfterReturning(
////            value = "execution(com.example.springaop.dto.Student " +
////                    "com.example.springaop.service.StudentService" +
////                    ".createStudent(com.example.springaop.dto.Student))",
////            returning = "result")
////    public void logAfterReturningMethod(Student result) {
////        //System.out.println("Log after returning");
////
////
////         result.setName("Harshit");
////         result.setAge(11);
////
////        System.out.println("Intercepted createstudent()");
////
////
////        //even we are returning s, the controller will not get a modified string
////       // return s;
////    }
//
////    @AfterThrowing(
////            value = "execution(* com.example.springaop.service.StudentService.createStudent(..))",
////            throwing = "exception")
////    public void logAfterThrowingMethod(Throwable exception) {
////        System.out.println("Exception type:  "+ exception.getClass().getName());
////        System.out.println("Exception message: "+ exception.getMessage());
////    }
//
//
//
//
////    @AfterThrowing(
////            value = "execution(* com.example.springaop.service.StudentService.createStudent(..))")
////    public void logAfterMethod() {
////        System.out.println("loginAfter method executed");
////    }
//
//
//
////    @Around(
////            value = "execution(* com.example.springaop.service.StudentService.createStudent(..))")
////    public Object  logAroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
////        System.out.println("Starting: "+ proceedingJoinPoint.getSignature().getName());
////        try{
////            Object result = proceedingJoinPoint.proceed();
////            System.out.println("Execution Successfull");
////            return result;
////        }catch(Exception ex){
////            System.out.println("Execution failed: "+ ex.getMessage());
////            throw ex;
////        }finally {
////            System.out.println("Execution completed");
////        }
////        //student.setAge(43);
////        //student.setName("Rana");
////    }
//
//
//    @Around(
//            value = "execution(* com.example.springaop.service.StudentService.dummyMethod(..))")
//    public Object  logAroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//
//        Object arr[] = proceedingJoinPoint.getArgs();
//        String s = (String)arr[0];
//
//        String modifiedString = s.toUpperCase();
//        Object [] modArr = {modifiedString};
//        return proceedingJoinPoint.proceed(modArr);
//    }
//}

