package com.example.dtoDemo.service;

import com.example.dtoDemo.entity.Student;
import com.example.dtoDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public Student createStudent(Student stud){
        return studentRepository.save(stud);
    }
}
