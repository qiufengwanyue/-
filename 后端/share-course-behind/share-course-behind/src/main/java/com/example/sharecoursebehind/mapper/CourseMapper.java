package com.example.sharecoursebehind.mapper;

import com.example.sharecoursebehind.entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseMapper {
    @Select("select * from `course` where area = #{area} order by cid desc")
    Course selectByArea(String area);

    @Select("select * from `course` where cid = #{cid} order by cid desc")
    Course selectByCid(Integer cid);

    @Update("UPDATE course SET report = #{report} WHERE cid = #{cid}")
    void updateReport(String report, Integer cid);

    @Insert("insert into `course`(uid,coursename,teacher,ccolloge,area,pernum,roomnum,introduce,warn,sort1,sort2,sort3,cpicture,reservenum,cumreservenum,score,likenum) values (#{uid},#{coursename}," +
            "#{teacher},#{ccolloge},#{area},#{pernum},#{roomnum},#{introduce},#{warn},#{sort1},#{sort2},#{sort3},#{cpicture},#{reservenum},#{cumreservenum},#{score},#{likenum})")
    void insert(Course course) ;
    @Select("select * from course")
    List<Course> selectAll();

    @Select("SELECT * FROM course WHERE report IS NOT NULL;")
    List<Course> selectByReport();

    @Update("UPDATE course SET report = NULL WHERE cid = #{cid}")
    void deleteReport(Integer cid);

    @Delete("DELETE FROM talk WHERE cid = (SELECT cid FROM course WHERE cid = #{cid})")
    void deleteCourseTalk(Integer cid);

    @Delete("DELETE FROM time WHERE cid = (SELECT cid FROM course WHERE cid = #{cid})")
    void deleteCourseTime(Integer cid);

    @Delete("DELETE FROM course WHERE cid = #{cid};")
    void deleteCourse(Integer cid);

//    @Select("Select * from 'course'")
//    static List<CourseInformation> selectAll() ;

}
