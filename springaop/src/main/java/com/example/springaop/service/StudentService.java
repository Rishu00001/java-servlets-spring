package com.example.springaop.service;

import com.example.springaop.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public Student createStudent(Student student){
        System.out.println("Student saved");
       //throw new RuntimeException("Exception before returning");
        return student;
    }
}
