package com.rishu.repository;

import com.rishu.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {
    private Map<Long, Student> studentDB;

    public StudentRepository(){
        studentDB = new HashMap<>();
    }

    public Student save(Student stud){
        studentDB.put(stud.getId(),stud);
        return stud;
    }

    public Student findById(Long id){
        return studentDB.getOrDefault(id,null);
    }
    public List<Student> findAll(){
        return new ArrayList<>(studentDB.values());
    }
}
