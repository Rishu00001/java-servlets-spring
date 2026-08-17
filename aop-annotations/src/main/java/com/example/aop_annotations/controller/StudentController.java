package com.example.aop_annotations.controller;

import com.example.aop_annotations.dto.Student;
import com.example.aop_annotations.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/student")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<Student> createStudent(
            @RequestBody Student student){
        Student studentResponse = studentService.createStudent(student);
        return ResponseEntity.ok(studentResponse);
    }

    @GetMapping
    public ResponseEntity<String> getStudent(){
        String s = "all students data";
        return ResponseEntity.ok(studentService.getStudent(s));
    }
}
