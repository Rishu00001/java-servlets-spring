package com.example.crud.service;

import com.example.crud.dto.CreateStudentRequestDTO;
import com.example.crud.dto.CreateStudentResponseDTO;
import com.example.crud.dto.UpdateStudentRequestDTO;
import com.example.crud.dto.UpdateStudentResponseDTO;
import com.example.crud.entity.Student;
import com.example.crud.exception.DuplicateResourceException;
import com.example.crud.exception.ResourceNotFoundException;
import com.example.crud.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private Student mapToEntity(CreateStudentRequestDTO dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());
        student.setCourse(dto.getCourse());
        return student;
    }

    private CreateStudentResponseDTO mapToDto(Student student) {
        CreateStudentResponseDTO dto = new CreateStudentResponseDTO();
        dto.setName(student.getName());
        dto.setAge(student.getAge());
        dto.setEmail(student.getEmail());
        dto.setCourse(student.getCourse());
        dto.setMessage("Hey there, I'm using DTO");
        return dto;
    }

    private UpdateStudentResponseDTO mapToUpdateDto(Student student) {
        UpdateStudentResponseDTO dto = new UpdateStudentResponseDTO();
        dto.setName(student.getName());
        dto.setAge(student.getAge());
        dto.setEmail(student.getEmail());
        dto.setCourse(student.getCourse());
        dto.setMessage("Student updated successfully");
        return dto;
    }

    public CreateStudentResponseDTO createStudent(CreateStudentRequestDTO dto) {
        Student student = mapToEntity(dto);
        if(emailExists(student)){
            throw new DuplicateResourceException("email already exists");
        }
        Student savedStudent = studentRepository.save(student);
        return mapToDto(savedStudent);
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No record exists"));
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public UpdateStudentResponseDTO updateStudent(Long id, UpdateStudentRequestDTO dto) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        existingStudent.setName(dto.getName());
        existingStudent.setAge(dto.getAge());
        existingStudent.setEmail(existingStudent.getEmail()); // Fixed
        existingStudent.setCourse(dto.getCourse());

        Student updatedStudent = studentRepository.save(existingStudent);

        return mapToUpdateDto(updatedStudent);
    }

    //helper function
    private boolean emailExists(Student stud){
        return studentRepository.existsByEmail(stud.getEmail());
    }
}