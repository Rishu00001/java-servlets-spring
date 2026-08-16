package com.example.springaop.controller;

import com.example.springaop.dto.Student;
import com.example.springaop.service.StudentService;
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
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student response = studentService.createStudent(student);
        return ResponseEntity.ok(response);
    }

//    @GetMapping
//    public ResponseEntity<String> dummyMethod(){
//        String s = "Ritik";
//        String response = studentService.dummyMethod(s);
//        return ResponseEntity.ok(response);
//    }

    @GetMapping()
    public ResponseEntity<String> getStudent(){
        String s = "All student data";
        String response = studentService.getStudent(s);
        return ResponseEntity.ok(response);
    }
}
