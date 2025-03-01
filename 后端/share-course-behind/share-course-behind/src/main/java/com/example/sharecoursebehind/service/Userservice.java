package com.example.sharecoursebehind.service;

import com.example.sharecoursebehind.entity.Course;
import com.example.sharecoursebehind.entity.User;
import com.example.sharecoursebehind.exception.ServiceException;
import com.example.sharecoursebehind.mapper.DayPlanMapper;
import com.example.sharecoursebehind.mapper.TimeTableMapper;
import com.example.sharecoursebehind.mapper.Usermapper;
import com.example.sharecoursebehind.mapper.WeekPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;

@Service
public class Userservice {
    @Autowired
    Usermapper usermapper;
    @Autowired
    TimeTableMapper timeTableMapper;
    @Autowired
    WeekPlanMapper weekPlanMapper;
    @Autowired
    DayPlanMapper dayPlanMapper;
//    public void insertuser(User user){
//        usermapper.insert(user);
//    }
public void insertuser(User user){
    User dbUser = usermapper.selectByUsername(user.getUsername());
    if(dbUser != null){
        throw new ServiceException("用户名重复");
    }else{
        user.setUpicture("http://localhost:8080/file/download/img.png");
        user.setAge(0);
        user.setGrade("大一");
        user.setUpnum(0);
        user.setAttnum(0);
        user.setPower(0);
        usermapper.insert(user);
        User newUser = usermapper.selectByUsername(user.getUsername());
        timeTableMapper.newTimeTable(newUser.getUid());
        dayPlanMapper.newDayPlan(newUser.getUid());
        weekPlanMapper.newWeekPlan(newUser.getUid());
    }
}

    public User login(User user) {
        //根据用户名查数据库
        User dbUser = usermapper.selectByUsername(user.getUsername());
        if(dbUser==null){
            throw new ServiceException("用户名或者密码错误");
        }
        if(!Objects.equals(user.getPassword(), dbUser.getPassword())){
            throw new ServiceException("用户名或者密码错误");
        }
        return dbUser;
    }

    public User search(User user) {
        User dbUser = usermapper.selectByUid(user.getUid());
        return dbUser;
    }

    public User update(User user) {
        User dbUser = usermapper.selectByUsername(user.getUsername());
        if(dbUser!=null && dbUser.getUid() != user.getUid()){
            throw new ServiceException("用户名重复");
        }
        else{
                usermapper.changeByUid(user);
                User dbbUser = usermapper.selectByUid(user.getUid());
                return dbbUser;
        }
  }

    public void up(String username) {
        username=username.substring(1, username.length() - 1);
        User dbUser = usermapper.selectByUsername(username);
        if(dbUser==null ){
            throw new ServiceException("没有该用户");
        }
        else{
            usermapper.up(username);
        }
    }

    public void down(String username) {
        username=username.substring(1, username.length() - 1);
        User dbUser = usermapper.selectByUsername(username);
        if(dbUser==null ){
            throw new ServiceException("没有该用户");
        }
        else{
            if(dbUser.getPower()!=1){
                throw new ServiceException("该用户不是管理员");
            }
            else {
                usermapper.down(username);
            }
        }
    }

    public List<User> selectByPower() {
        List<User> dbuserList = usermapper.selectByPower();
        return dbuserList;
    }
}
