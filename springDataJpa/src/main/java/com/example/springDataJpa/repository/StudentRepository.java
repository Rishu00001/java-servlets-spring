package com.example.springDataJpa.repository;

import com.example.springDataJpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository
        extends JpaRepository<Student,Long>{

}
