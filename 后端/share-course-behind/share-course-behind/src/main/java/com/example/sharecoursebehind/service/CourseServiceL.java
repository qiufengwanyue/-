package com.example.sharecoursebehind.service;

import com.example.sharecoursebehind.entity.Course;
import com.example.sharecoursebehind.entity.User;
import com.example.sharecoursebehind.exception.ServiceException;
import com.example.sharecoursebehind.mapper.CourseMapper;
import com.example.sharecoursebehind.mapper.CourseMapperL;
import com.example.sharecoursebehind.mapper.Usermapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

@Service
public class CourseServiceL {
    @Autowired
    CourseMapperL courseMapperL;


    public List<Course> selectAll() {
        return courseMapperL.selectAll();
    }

    public List<Course> selectByCoursename(String coursename) {
        return courseMapperL.selectByCoursename(coursename);
    }

    public List<Course> selectByMo(String coursename) {
        return courseMapperL.selectByMo(coursename);
    }

    public List<Course> selectByMoSchool(String ccolloge) {
        return courseMapperL.selectByMoSchool(ccolloge);
    }

    public List<Course> selectByMoTeacher(String teacher) {
        return courseMapperL.selectByMoTeacher(teacher);
    }



    public List<Course> selectByCid(Integer cid) {
        return courseMapperL.selectByCid(cid);
    }

    public void updateLikenum(Integer likenum, Integer cid) {
        courseMapperL.updateLikenum(likenum, cid);
    }

    public void updatePernum(Integer pernum, Integer cid) {
        courseMapperL.updatePernum(pernum, cid);
    }

    public List<Course> selectByUid(Integer uid) {return courseMapperL.selectByUid(uid);
    }
//    public void insertCourse(CourseInformation courseInformation){
//
//    }


//    public static List<CourseInformation> selectAll() {
//        return CourseInformationMapper.selectAll();
//    }
}
