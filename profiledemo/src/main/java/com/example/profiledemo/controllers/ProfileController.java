package com.example.profiledemo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping("api/profile/")
public class ProfileController {
    @Value("${profile.message}")
    private String message;
    @GetMapping("/greet")
    public ResponseEntity<String> greet(){
        return ResponseEntity.ok(message);
    }
}
