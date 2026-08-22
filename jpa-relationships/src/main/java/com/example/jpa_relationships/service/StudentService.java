package com.example.jpa_relationships.service;

import com.example.jpa_relationships.enums.DepartmentType;
import com.example.jpa_relationships.model.Department;
import com.example.jpa_relationships.model.Student;
import com.example.jpa_relationships.repository.DepartmentRepository;
import com.example.jpa_relationships.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private DepartmentRepository departmentRepository;
    public StudentService(StudentRepository studentRepository,
                          DepartmentRepository departmentRepository){
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }
//    @Transactional
//    public Student createStudent(Student student,Long deptId ){
//        Department department =
//                departmentRepository.getDepartmentById(deptId);
//        student.setDepartment(department);
//        return studentRepository.save(student);
//    }

    @Transactional
    public Student createStudent(Student student, DepartmentType dept) {

        Department department = departmentRepository.findByName(dept)
                .orElseGet(() -> {
                    Department newDepartment = new Department();
                    newDepartment.setName(dept);
                    return departmentRepository.save(newDepartment);
                });

        student.setDepartment(department);
        department.getStudents().add(student);

        return studentRepository.save(student);
    }
}
