package com.example.springboot.demo.service;

import com.example.springboot.demo.Mapper.UserMapper;
import com.example.springboot.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

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
}
















