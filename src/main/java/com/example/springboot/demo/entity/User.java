package com.example.springboot.demo.entity;

import lombok.Data;

@Data
public class User {
    private String username;
    private int id;
    private String password;

    public User(int id,String username){
        this.id = id;
        this.username = username;
    }
}























