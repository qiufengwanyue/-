package com.example.sharecoursebehind.controller;

import cn.hutool.core.util.StrUtil;
import com.example.sharecoursebehind.common.Result;
import com.example.sharecoursebehind.entity.Course;
import com.example.sharecoursebehind.entity.User;
import com.example.sharecoursebehind.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController()
@RequestMapping("/user")
public class Usercontroller {
    @Autowired
    Userservice userservice;

    @PostMapping("/putpower")
    public Result putpower(){
        List<User> userList= userservice.selectByPower();
        return Result.success(userList);
    }
    @PostMapping("/add")
    public Result add(@RequestBody User user){
        userservice.insertuser(user);
        return Result.success();
    }

    @PostMapping("/search")
    public Result login(@RequestBody User user){
        user=userservice.search(user);
        return Result.success(user);
    }

    @PostMapping("/update")
    public Result update(@RequestBody User newUser){
        newUser=userservice.update(newUser);
        return Result.success(newUser);
    }

    @PostMapping("/up")
    public Result up(@RequestBody String username){
        userservice.up(username);
        return Result.success();
    }

    @PostMapping("/down")
    public Result down(@RequestBody String username){
        userservice.down(username);
        return Result.success();
    }
}
