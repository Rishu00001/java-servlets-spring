package com.example.jpa_relationships.service;

import com.example.jpa_relationships.model.Department;
import com.example.jpa_relationships.model.Student;
import com.example.jpa_relationships.repository.DepartmentRepository;
import com.example.jpa_relationships.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;
    private StudentRepository studentRepository;
    public DepartmentService(DepartmentRepository departmentRepository,
                             StudentRepository studentRepository){
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
    }
    @Transactional
    public Department createDepartment(Department department){

        return departmentRepository.save(department);
    }
    @Transactional
    public Department createDepartment(Department department,
                                       String studentName){
        Student student = new Student();
        student.setName(studentName);
        student.setDepartment(department);
        department.getStudents().add(student);
        studentRepository.save(student);
        departmentRepository.save(department);
        return department;
    }

    @Transactional
    public Department getDepartmentById(Long deptId){
        return departmentRepository.getDepartmentById(deptId);
    }
}
