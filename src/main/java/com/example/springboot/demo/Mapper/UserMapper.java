package com.example.springboot.demo.Mapper;

import com.example.springboot.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserMapper {
    User getById(int id);
    //登录
    public User login(@Param("username")String userName, @Param("password")String password);

     //判断用户名是否重复
    public void register(User user);
    public List<User> getUsers();

}















