package com.example.springaop.controller;

import com.example.springaop.dto.Student;
import com.example.springaop.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/student")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println("Student = " + student.getName());
        Student response = studentService.createStudent(student);
        return ResponseEntity.ok(response);
    }
}
