package com.example.aop.repository;

import com.example.aop.dto.StudentDto;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    public void save(StudentDto stud){
        System.out.println("student saved to db");
    }
}
