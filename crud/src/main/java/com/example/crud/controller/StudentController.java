package com.example.crud.controller;

import com.example.crud.dto.CreateStudentRequestDTO;
import com.example.crud.dto.CreateStudentResponseDTO;
import com.example.crud.dto.UpdateStudentRequestDTO;
import com.example.crud.dto.UpdateStudentResponseDTO;
import com.example.crud.entity.Student;
import com.example.crud.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Create Student
    @PostMapping
    public ResponseEntity<?> createStudent(@Valid @RequestBody CreateStudentRequestDTO student) {

        CreateStudentResponseDTO createdStudent = studentService.createStudent(student);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Data inserted successfully");
        response.put("data", createdStudent);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Read One Student
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable Long id) {

        Student student = studentService.getStudent(id);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Data fetched successfully");
        response.put("data", student);

        return ResponseEntity.ok(response);
    }

    // Read All Students
    @GetMapping
    public ResponseEntity<?> getAllStudents() {

        List<Student> studentList = studentService.getAllStudents();

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Fetched all students successfully");
        response.put("data", studentList);

        return ResponseEntity.ok(response);
    }

    // Update Student
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(
            @PathVariable Long id,
            @RequestBody UpdateStudentRequestDTO stud) {

        UpdateStudentResponseDTO updatedStudent = studentService.updateStudent(id, stud);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Student data updated successfully");
        response.put("data", updatedStudent);

        return ResponseEntity.ok(response);
    }
}