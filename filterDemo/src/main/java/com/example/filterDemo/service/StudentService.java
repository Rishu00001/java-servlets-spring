package com.example.filterDemo.service;

import com.example.filterDemo.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public void createStudent(Student student) throws InterruptedException {
        System.out.println("Student created");
        System.out.println(student.getName());
        System.out.println(student.getEmail());

        Thread.sleep(900);
    }
}
