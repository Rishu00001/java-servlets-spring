package com.rishu.controller;

import com.rishu.entity.Student;
import com.rishu.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student studentReq){
        Student studentResponse = studentService.createStudent(studentReq);
        return ResponseEntity.ok(studentResponse);
    }
    @GetMapping("/get")
    public ResponseEntity<?> getAllStudents(){
        List<Student> studentResponse = studentService.getAllStudents();
        return ResponseEntity.ok(studentResponse);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id){
        Student studentResponse = studentService.getStudentById(id);
        return ResponseEntity.ok(studentResponse);
    }
}
