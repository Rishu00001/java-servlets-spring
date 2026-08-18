package com.rishu.repository;

import com.rishu.model.Student;

import java.sql.*;

public class StudentRepository {
    private String url = "jdbc:mysql://localhost:3306/learnsql";
    private String username = "root";
    private String password = "ninja";

    public void createUser(){
        try {
            Connection connection = DriverManager
                    .getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "insert into student values(71,'Rama',32,'Gaya')";
            /*There are three ways to execute statement
            1. executeUpdate - create, update, delete
            2. executeQuery - select
            3. execute - general purpose
             */
            int result = statement.executeUpdate(sql);
            if(result == 0){
                System.out.println("Data not inserted");
            }else{
                System.out.println("Data inserted successfully");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
    }
    public void updateUser(){
        try {
            Connection connection = DriverManager
                    .getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "update student set age = 45 where id = 71";
            /*There are three ways to execute statement
            1. executeUpdate - create, update, delete
            2. executeQuery - select
            3. execute - general purpose
             */
            int result = statement.executeUpdate(sql);
            if(result == 0){
                System.out.println("update failed");
            }else{
                System.out.println("Data updated successfully");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
    }
    public void getUsers(){
        try {
            Connection connection = DriverManager
                    .getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String sql = "select name, age, city from student";
            /*There are three ways to execute statement
            1. executeUpdate - create, update, delete
            2. executeQuery - select
            3. execute - general purpose
             */
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet == null){
                System.out.println("Read operation failed");
            }else{
                while(resultSet.next()){
                    Student student = mapRow(resultSet);
                    System.out.println(student);
                }
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
    }
    private Student mapRow(ResultSet res) throws SQLException {
        Student student = new Student();
        student.setName(res.getString("name"));
        student.setAge(res.getInt("age"));
        student.setCity(res.getString("city"));
        return student;
    }
}
