package com.example.filterDemo.service;

import com.example.filterDemo.dto.Student;
import com.example.filterDemo.dto.StudentResponseDto;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public StudentResponseDto createStudent(Student student) throws InterruptedException {

        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setName(student.getName());
        studentResponseDto.setMessage("Saved Successfully");
        return studentResponseDto;
        //Thread.sleep(900);
    }
}
