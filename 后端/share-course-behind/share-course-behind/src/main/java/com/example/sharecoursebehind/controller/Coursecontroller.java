package com.example.sharecoursebehind.controller;

import cn.hutool.core.util.StrUtil;
import com.example.sharecoursebehind.common.Result;
import com.example.sharecoursebehind.entity.Course;
import com.example.sharecoursebehind.entity.CourseTime;
import com.example.sharecoursebehind.entity.Time;
import com.example.sharecoursebehind.entity.User;
import com.example.sharecoursebehind.service.CourseService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController()
@RequestMapping("/course")
public class Coursecontroller {
    @Resource
    CourseService courseService;


    @PostMapping("/deletecourse")
    public Result deletecourse(@RequestBody Integer cid){
        courseService.deleteCourse(cid);
        return Result.success(cid);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer cid){
        courseService.deleteReport(cid);
    }


    @PostMapping("/upreport")
    public void update(@RequestBody String date){
        date = date.trim().replace("\"", "");
        String[] parts = date.split("&&\\$\\$");
        String report = parts[0];
        String cidStr = parts[1];
        int cid = Integer.parseInt(cidStr);
        courseService.upreport(cid,report);
    }

    @PostMapping("/putreport")
    public Result putreport(){
        List<Course> courseList= courseService.selectByReport();
        return Result.success(courseList);
    }

    @PostMapping("/update")
    public Result login(@RequestBody CourseTime coursetime){
        Course course = new Course();
        course.setCoursename(coursetime.getCoursename());
        course.setTeacher(coursetime.getTeacher());
        course.setArea(coursetime.getArea());
        course.setCcolloge(coursetime.getCcolloge());
        course.setPernum(coursetime.getPernum());
        course.setRoomnum(coursetime.getRoomnum());
        course.setIntroduce(coursetime.getIntroduce());
        course.setWarn(coursetime.getWarn());
        course.setUid(coursetime.getUid());
        course.setCpicture(coursetime.getCpicture());
        course.setSort1(coursetime.getSort1());
        course.setSort2(coursetime.getSort2());
        course.setSort3(coursetime.getSort3());
        Time time = new Time();
        time.setRank(coursetime.getRank());
        time.setDate(coursetime.getDate());
        if(StrUtil.isBlank(course.getCoursename())||StrUtil.isBlank(course.getTeacher())||StrUtil.isBlank(course.getArea())||StrUtil.isBlank(course.getCcolloge())
                ||course.getPernum() == null||course.getRoomnum() == null||StrUtil.isBlank(course.getIntroduce())||StrUtil.isBlank(course.getWarn())||StrUtil.isBlank(course.getCpicture())
                ||StrUtil.isBlank(course.getSort1())||StrUtil.isBlank(course.getSort2())||StrUtil.isBlank(course.getSort3())){
            return Result.error("数据输入不全");
        }
        course=courseService.update(course,time,coursetime.getDay());
        return Result.success(course);
       }

//    @GetMapping("/select")
//        public Result selectAll(){
//            List<Course> courseList= courseService.selectAll();
//            return Result.success(courseList);
    }


