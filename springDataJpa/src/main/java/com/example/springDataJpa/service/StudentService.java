package com.example.springDataJpa.service;

import com.example.springDataJpa.model.Student;
import com.example.springDataJpa.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    @Transactional
    public Student createStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Student not found")
        );
    }
    public Student updateStudent(Student studentReq, Long id){
        Optional<Student> studentRes = studentRepository.findById(id);
        Student student;
        if(studentRes.isPresent()){
            student = studentRes.get();

            student.setAge(studentReq.getAge());
            student.setName(studentReq.getName());
            student.setEmail(studentReq.getEmail());
        }
        else{
            student = null;
        }
        return student;
    }

    @Transactional
    public List<Student> getAllStudents(){
        Sort sort = Sort.by("age").descending();
        return studentRepository.findAll(sort);
    }
}
