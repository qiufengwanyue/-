package com.example.sharecoursebehind.service;

import com.example.sharecoursebehind.entity.Course;
import com.example.sharecoursebehind.entity.Time;
import com.example.sharecoursebehind.entity.User;
import com.example.sharecoursebehind.exception.ServiceException;
import com.example.sharecoursebehind.mapper.CourseMapper;
import com.example.sharecoursebehind.mapper.TimeMapper;
import com.example.sharecoursebehind.mapper.Usermapper;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

@Service
public class CourseService {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    TimeMapper timeMapper;
//    public Course update(Course course, Time time,Integer day) {
//        Boolean test=true;
//        String[] array =time.getDate().split("#");
//        Course dbCourse = courseMapper.selectByArea(course.getArea());
//        for(int i=0;i<day;i++){
//        Time dbTime=timeMapper.selectByTime(array[i],time.getRank());
//        if(dbCourse!=null&&dbTime!=null){
//            if(dbCourse.getCid()==dbTime.getCid()){test=false;};
//        }
//        }
//        if(!test){
//            throw new ServiceException("课程重复");
//        }else{
//            courseMapper.insert(course);
//            Course newCourse = courseMapper.selectByArea(course.getArea());
//            time.setCid(newCourse.getCid());
//            for(int i=0;i<day;i++){
//                time.setDate(array[i]);
//                timeMapper.insert(time);
//            }
//        }
//        return dbCourse;
//    }
//public Course update(Course course, Time time,Integer day) {
//    Course dbCourse = courseMapper.selectByArea(course.getArea());
//    Time dbTime = timeMapper.selectCheck(course.getArea(), time.getDate(), time.getRank());
//    if(dbTime!= null){
//        throw new ServiceException("课程重复");
//    }else{
//        courseMapper.insert(course);
//        Course newCourse = courseMapper.selectByArea(course.getArea());
//        time.setCid(newCourse.getCid());
//        String[] array =time.getDate().split("#");
//        for(int i=0;i<day;i++){
//            time.setDate(array[i]);
//            timeMapper.insert(time);
//        }
//    }
//    return dbCourse;
//}

    public Course update(Course course, Time time,Integer day) {
        Course dbCourse = courseMapper.selectByArea(course.getArea());
        if(dbCourse != null){
            throw new ServiceException("课程重复");
        }else{
            courseMapper.insert(course);
            Course newCourse = courseMapper.selectByArea(course.getArea());
            time.setCid(newCourse.getCid());
            String[] array =time.getDate().split("#");
            for(int i=0;i<day;i++){
                time.setDate(array[i]);
                timeMapper.insert(time);
            }
        }
        return dbCourse;
    }

    public void upreport(Integer cid, String report) {
        Course dbCourse = courseMapper.selectByCid(cid);
        System.out.println(dbCourse.getReport());
        dbCourse.setReport(dbCourse.getReport()+"#$#$"+report);
        courseMapper.updateReport(dbCourse.getReport(),cid);
    }

    public List<Course> selectByReport() {
        List<Course> dbcourseList = courseMapper.selectByReport();
        return dbcourseList;
    }

    public void deleteReport(Integer cid) {
        courseMapper.deleteReport(cid);
    }


    public void deleteCourse(Integer cid) {
        courseMapper.deleteCourseTime(cid);
        courseMapper.deleteCourseTalk(cid);
        courseMapper.deleteCourse(cid);
    }

//    public void insertCourse(CourseInformation courseInformation){
//
//    }


//    public static List<CourseInformation> selectAll() {
//        return CourseInformationMapper.selectAll();
//    }
}
