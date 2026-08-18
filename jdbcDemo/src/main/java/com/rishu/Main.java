package com.rishu;

import com.rishu.repository.StudentRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.getUsers();
    }
}

