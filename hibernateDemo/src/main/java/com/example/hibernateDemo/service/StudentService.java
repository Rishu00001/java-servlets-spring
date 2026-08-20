package com.example.hibernateDemo.service;


import com.example.hibernateDemo.model.Student;
import com.example.hibernateDemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return null;
    }

    @Transactional
    public Student getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public void updateStudent(Student studentRequest, Long id) {
        Student student = studentRepository.findById(id);
        if(student == null){
            throw new RuntimeException("Student not found");
        }
        student.setName(studentRequest.getName());
        student.setAge(studentRequest.getAge());
        student.setCity(studentRequest.getCity());

    }

    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id);
        if(student == null){
            throw new RuntimeException("Student not found");
        }
        studentRepository.remove(student);
    }
}
