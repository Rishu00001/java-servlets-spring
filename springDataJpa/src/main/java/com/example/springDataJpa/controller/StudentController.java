package com.example.springDataJpa.controller;

import com.example.springDataJpa.model.Student;
import com.example.springDataJpa.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(
            @RequestBody Student student){
        Student studentResponse =
                studentService.createStudent(student);
        return ResponseEntity.ok(studentResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        Student studentResponse = studentService.getStudentById(id);
        return ResponseEntity.ok(studentResponse);
    }
    @GetMapping
    public ResponseEntity<List<Student>> getALlStudents(
            @PathVariable String name){
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
}
