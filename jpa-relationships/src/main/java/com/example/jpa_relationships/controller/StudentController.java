package com.example.jpa_relationships.controller;

import com.example.jpa_relationships.enums.DepartmentType;
import com.example.jpa_relationships.model.Student;
import com.example.jpa_relationships.service.StudentService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/student")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
//    @PostMapping("/{deptId}")
//    public ResponseEntity<Student> createStudent(@RequestBody Student student,
//                                                 @PathVariable Long deptId){
//        Student response = studentService.createStudent(student,deptId);
//        return ResponseEntity.ok(response);
//    }

    @PostMapping
    public ResponseEntity<Student> createStudent(
            @RequestBody Student student,
            @RequestParam DepartmentType dept){
        Student response = studentService.createStudent(student,dept);
        return ResponseEntity.ok(response);
    }
}
