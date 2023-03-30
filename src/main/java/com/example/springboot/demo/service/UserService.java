package com.example.springboot.demo.service;

import com.example.springboot.demo.Mapper.StudentMapper;
import com.example.springboot.demo.Mapper.UserMapper;
import com.example.springboot.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StudentMapper studentMapper;

    public User getById(int id){
        return userMapper.getById(id);
    }

    public User login(String userName,String password){
        User user=userMapper.login(userName,password);
        return user;
    }


    public void register(User user) {
        userMapper.register(user);
    }

    public List<User> getUsers() {
        return userMapper.getUsers();
    }

    public void deleteAllUsers() {
        userMapper.deleteAllUsers();
    }


    public void test(){
        try{
            this.test1();
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
       this.test2();
    }

    private void test1(){
        userMapper.getUsers();
        userMapper.deleteAllUsers();
    }

    private void test2(){
        studentMapper.getStudents();
        studentMapper.deleteAllStudents();
    }
}
















