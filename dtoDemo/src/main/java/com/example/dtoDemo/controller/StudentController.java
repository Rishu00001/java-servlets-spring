package com.example.dtoDemo.controller;

import com.example.dtoDemo.entity.Student;
import com.example.dtoDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    //create
    public ResponseEntity<Student> createStudent(@RequestBody Student studentReq){
        Student studentResponse = studentService.createStudent(studentReq);
        return ResponseEntity.ok(studentResponse);
    }
    //read

    //update

    //delete
}
