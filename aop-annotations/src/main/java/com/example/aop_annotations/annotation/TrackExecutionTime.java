package com.example.aop_annotations.annotation;

//marker annotation
//Configured annotation
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)  //default policy is runtime
@Documented
public @interface TrackExecutionTime {
    long warnAfter() default 2000;

    String operation() default "";
}

/*
* Where the annotation can be applied?
* How long the annotation will be available?
* */