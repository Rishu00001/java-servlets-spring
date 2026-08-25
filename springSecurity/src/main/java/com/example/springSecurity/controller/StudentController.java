package com.example.springSecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/student")
public class StudentController {

    @PostMapping
    public ResponseEntity<String> createStudent(){
        return ResponseEntity.ok("Created Successfully");
    }

    @GetMapping
    public CsrfToken getToken(CsrfToken csrfToken){
        return csrfToken;
    }
}
