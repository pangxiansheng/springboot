package com.example.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.example.springboot.demo.Mapper")
@EnableCaching
@ComponentScan (basePackages = {"com.example.springboot.demo.service","com.example.springboot.demo.Mapper","com.example.springboot.demo.controller"})
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

















