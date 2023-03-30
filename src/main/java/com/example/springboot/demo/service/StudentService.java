package com.example.springboot.demo.service;

import com.example.springboot.demo.Mapper.StudentMapper;
import com.example.springboot.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public List<Student> getStudents() {
        return studentMapper.getStudents();
    }

    public void deleteAllStudents() {
        studentMapper.deleteAllStudents();
    }
}
















