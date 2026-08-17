package com.example.aop_annotations.service;

import com.example.aop_annotations.annotation.TrackExecutionTime;
import com.example.aop_annotations.dto.Student;
import jdk.jfr.Timestamp;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public Student createStudent(Student student){
        System.out.println("student saved");
        return student;
    }
    @TrackExecutionTime(warnAfter = 1500,operation = "get student data")
    public String getStudent(String s){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(s);
        return s;
    }
}
