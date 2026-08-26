package com.example.springsecurity2.controller;

import com.example.springsecurity2.dto.UserRegisterRequestDto;
import com.example.springsecurity2.dto.UserRegisterResponseDto;
import com.example.springsecurity2.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {
    private AuthService authService;
    public UserController(AuthService authService)
    {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto>
    register(@Valid @RequestBody UserRegisterRequestDto registerRequestDto){
        UserRegisterResponseDto response =
                authService.registerUser(registerRequestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
