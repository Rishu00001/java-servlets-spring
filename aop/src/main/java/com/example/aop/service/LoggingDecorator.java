package com.example.aop.service;

import com.example.aop.LoggingServiceUtil;
import com.example.aop.dto.StudentDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class LoggingDecorator implements StudentService{
    private StudentServiceImpl studentService;
    public LoggingDecorator(StudentServiceImpl studentService){
        this.studentService = studentService;
    }
    @Override
    public void createStudent(StudentDto stud) {
        //Logging related logic
        LoggingServiceUtil.logStart("StudentServiceImpl","createStudent");
        studentService.createStudent(stud);
        LoggingServiceUtil.logEnd("studentServiceImpl","createStudent");

    }
}
