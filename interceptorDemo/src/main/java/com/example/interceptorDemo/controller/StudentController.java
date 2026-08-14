package com.example.interceptorDemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/student")
public class StudentController {
    @PostMapping
    public ResponseEntity<String> createStudent(){
        System.out.println("In Controller");
        return ResponseEntity.ok("Student created");
    }
}
