package com.example.springboot.demo.Mapper;

import com.example.springboot.demo.entity.Student;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {


    public List<Student> getStudents();


    public boolean deleteAllStudents();
}















