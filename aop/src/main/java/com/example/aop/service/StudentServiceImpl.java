package com.example.aop.service;

import com.example.aop.LoggingServiceUtil;
import com.example.aop.dto.StudentDto;
import com.example.aop.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public void createStudent(StudentDto stud){

        studentRepository.save(stud);

    }
}
