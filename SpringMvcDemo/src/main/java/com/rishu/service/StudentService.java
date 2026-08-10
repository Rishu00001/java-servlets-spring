package com.rishu.service;

import com.rishu.entity.Student;
import com.rishu.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student stud){
        return studentRepository.save(stud);
    }
    public Student getStudentById(Long id){
        return studentRepository.findById(id);
    }
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
}
