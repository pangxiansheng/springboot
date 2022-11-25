package com.example.springboot.demo.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSON;
import com.example.springboot.demo.entity.User;
import com.example.springboot.demo.service.UserService;
import com.example.springboot.demo.utils.JsonResult;
import com.example.springboot.demo.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/index") //在类上使用RequestMapping，里面设置的value就是方法的父路径
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hi")  //如果方法上的RequestMapping没有value，则此方法默认被父路径调用
    public String index(){
        return "hello spring boot";
    }

    @RequestMapping(value = "/login",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String login(String userName, String password){
        System.out.println(userName);
        System.out.println(password);
        User user=userService.login(userName,password);
        JsonResult jsonResult=new JsonResult();
        if (user==null){
            jsonResult.setSuccess(false);
            return JSON.toJSONString(jsonResult);
        }
        jsonResult.setSuccess(true);
        jsonResult.setResult(user);
        return JSON.toJSONString(jsonResult);
    }

    @RequestMapping(value = "/register",produces="text/html;charset=UTF-8")
                   @ResponseBody
                   public void register(User user){
                       System.out.println(user.getUsername());
                       System.out.println(user.getPassword());
                       JsonResult jsonResult=new JsonResult();
                       if(user!=null&&StringUtil.isNotEmpty(user.getUsername())&&StringUtil.isNotEmpty(user.getPassword())){
                           List<User> list=userService.getUsers();
                           list.forEach(str->{
                               if(str.getUsername().equals(user.getUsername())){
                                   jsonResult.setMessage("用户名已存在");
                               }else{
                                   jsonResult.setSuccess(true);
                   userService.register(user);
               }
                    });
//            if(list.contains(user.getUsername())){
//                jsonResult.setMessage("用户名已存在");
//            }else{
//                jsonResult.setSuccess(true);
//                userService.register(user);
//            }
        }else{
            jsonResult.setMessage("用户名和密码不能为空");
        }
    }

    //获取所有用户信息
    @RequestMapping(value = "/getUserList",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getUserList() {
        List<User> list = userService.getUsers();
        return  JSON.toJSONString(list);
    }
}
























