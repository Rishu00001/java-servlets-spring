package com.example.springaop.service;

import com.example.springaop.dto.Student;
import jdk.jfr.Timestamp;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Timestamp
    public Student createStudent(Student student){
        System.out.println("Student saved");
       //throw new RuntimeException("Exception before returning");
        return student;
    }

//    public String dummyMethod(String s){
//        return s;
//    }

    public String getStudent(String s){

        return s;
    }

    public int dummyMethod(){
        return 0;
    }


}
