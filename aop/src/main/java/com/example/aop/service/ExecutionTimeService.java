package com.example.aop.service;

import com.example.aop.dto.StudentDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ExecutionTimeService implements StudentService{
    private LoggingDecorator loggingDecorator;
    public ExecutionTimeService(LoggingDecorator loggingDecorator){
        this.loggingDecorator = loggingDecorator;
    }
    @Override
    public void createStudent(StudentDto stud) {
        long start = System.currentTimeMillis();
        loggingDecorator.createStudent(stud);
        long end = System.currentTimeMillis();
        System.out.println("Duratiion : "+ (end-start));
    }
}
