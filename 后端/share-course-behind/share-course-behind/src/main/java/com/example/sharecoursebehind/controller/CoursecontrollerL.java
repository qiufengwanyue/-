package com.example.sharecoursebehind.controller;

import cn.hutool.core.util.StrUtil;
import com.example.sharecoursebehind.common.Result;
import com.example.sharecoursebehind.entity.Course;
import com.example.sharecoursebehind.entity.Time;
import com.example.sharecoursebehind.service.CourseServiceL;
import com.example.sharecoursebehind.service.Userservice;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController()
@RequestMapping("/course")
public class CoursecontrollerL {
    @Resource
    CourseServiceL courseServiceL;

    @GetMapping("/select")
    public Result selectAll(){
        List<Course> courseList= courseServiceL.selectAll();
        return Result.success(courseList);
    }

    @GetMapping("/selectByCoursename/{coursename}")
    public Result selectByCoursename(@PathVariable String coursename){
        List<Course> courseList= courseServiceL.selectByCoursename(coursename);
        return Result.success(courseList);
    }


    @GetMapping("/selectByMo/{coursename}")
    public Result selectByMo(@PathVariable String coursename){
        List<Course> courseList= courseServiceL.selectByMo(coursename);
        return Result.success(courseList);
    }

    @GetMapping("/selectByMoSchool/{ccolloge}")
    public Result selectByMoSchool(@PathVariable String ccolloge){
        List<Course> courseList= courseServiceL.selectByMoSchool(ccolloge);
        return Result.success(courseList);
    }

    @GetMapping("/selectByMoTeacher/{teacher}")
    public Result selectByMoTeacher(@PathVariable String teacher){
        List<Course> courseList= courseServiceL.selectByMoTeacher(teacher);
        return Result.success(courseList);
    }

    @GetMapping("/selectByMoCid/{cid}")
    public Result selectByMoCid(@PathVariable Integer cid){
        List<Course> courseList= courseServiceL.selectByCid(cid);
        return Result.success(courseList);
    }

    @GetMapping("/selectByMoUid/{uid}")
    public Result selectByMoUid(@PathVariable Integer uid){
        List<Course> courseList= courseServiceL.selectByUid(uid);
        return Result.success(courseList);
    }
    @PostMapping("/updateLikenum")
    public Result updateLikenum(@RequestBody Map<String, Integer> requestData) {
        Integer likenum = requestData.get("likenum");
        Integer cid = requestData.get("cid");
        courseServiceL.updateLikenum(likenum, cid);
        return Result.success();
    }

    @PostMapping("/updatePernum")
    public Result updatePernum(@RequestBody Map<String, Integer> requestData) {
        Integer pernum = requestData.get("pernum"); // 修改参数获取键名为 pernum
        Integer cid = requestData.get("cid");
        courseServiceL.updatePernum(pernum, cid);
        return Result.success();
    }
}

