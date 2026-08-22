package com.example.jpa_relationships.service;

import com.example.jpa_relationships.model.Department;
import com.example.jpa_relationships.model.Student;
import com.example.jpa_relationships.repository.DepartmentRepository;
import com.example.jpa_relationships.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;
    private StudentRepository studentRepository;
    public DepartmentService(DepartmentRepository departmentRepository,
                             StudentRepository studentRepository){
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
    }
  //  @Transactional
//    public Department createDepartment(Department department){
//
//        Student s1 = new Student();
//        s1.setName("Ritik");
//        s1.setDepartment(department);
//        Student s2 = new Student();
//        s2.setName("Rohan");
//        s2.setDepartment(department);
//        Student s3 = new Student();
//        s3.setName("Sohan");
//        s3.setDepartment(department);
//        Student s4 = new Student();
//        s4.setName("Mohan");
//        s4.setDepartment(department);
//
//        department.getStudents().addAll(List.of(s1,s2,s3,s4));
//        departmentRepository.save(department);
//        return department;
//    }
    @Transactional
    public void removeDepartment(Long deptId){
        Department department =
                departmentRepository.getDepartmentById(deptId);
        departmentRepository.removeDepartment(department);
    }











//    @Transactional
//    public Department createDepartment(Department department,
//                                       String studentName){
//        Student student = new Student();
//        student.setName(studentName);
//        student.setDepartment(department);
//        department.getStudents().add(student);
//        studentRepository.save(student);
//        departmentRepository.save(department);
//        return department;
//    }

    @Transactional
    public Department getDepartmentById(Long deptId){

        return departmentRepository.getDepartmentById(deptId);
    }
}
