package com.example.sharecoursebehind.controller;

import cn.hutool.core.util.StrUtil;
import com.example.sharecoursebehind.common.Result;
import com.example.sharecoursebehind.entity.User;
import com.example.sharecoursebehind.service.Userservice;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

//提供接口，返回数据
@RestController
public class WebController {
    //@RequestMapping(method = RequestMethod.GET)    //表示这个方法是提供数据的
    @Resource
    Userservice userservice;
    @RequestMapping("/")
    public Result hello(){
        return Result.success("success");
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        if(StrUtil.isBlank(user.getUsername())||StrUtil.isBlank(user.getPassword())){
            return Result.error("数据输入不合法");
        }
        user=userservice.login(user);
        return Result.success(user);
    }

//    @PostMapping("/post")                             //url参数
//    public Result post(Obi obj){
//        return Result.success(obj);
//    }

//    @PostMapping("/post")                            //json参数
//    public Result post(@RequestBody Obj obj){           //新增数据
//        return Result.success(obj);
//    }
//
//    @PutMapping("/put")                            //常用来更新数据
//    public Result put(@RequestBody Obj obj){
//        return Result.success(obj);
//    }
//    @DeleteMapping("/delete/{id}")                  //路径参数
//    public Result delete(@PathVariable Integer id){
//        return Result.success(id);
//    }
}

