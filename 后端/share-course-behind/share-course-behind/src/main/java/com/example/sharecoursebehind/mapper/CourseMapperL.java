package com.example.sharecoursebehind.mapper;

import com.example.sharecoursebehind.entity.Course;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CourseMapperL {
    @Select("select * from `course` where area = #{area} order by cid desc")
    Course selectByArea(String area);

    @Insert("insert into `course`(uid,coursename,teacher,Ccolloge,area,pernum,roomnum,introduce,warn,sort1,sort2,sort3,reservenum,cumreservenum,score,likenum) values (#{uid},#{coursename}," +
            "#{teacher},#{Ccolloge},#{area},#{pernum},#{roomnum},#{introduce},#{warn},#{sort1},#{sort2},#{sort3},#{reservenum},#{cumreservenum},#{score},#{likenum})")
    void insert(Course course) ;
    @Select("SELECT * FROM course ORDER BY cid DESC;")
    List<Course> selectAll();


    @Select("SELECT * FROM course where coursename =#{coursename} ORDER BY cid DESC;")
    List<Course> selectByCoursename(String coursename);


    @Select("SELECT * FROM course where coursename like concat('%',#{coursename},'%') ORDER BY cid DESC;")
    List<Course> selectByMo(String coursename);


    @Select("SELECT * FROM course where ccolloge like concat('%',#{ccolloge},'%') ORDER BY cid DESC;")
    List<Course> selectByMoSchool(String ccolloge);


    @Select("SELECT * FROM course where teacher like concat('%',#{teacher},'%') ORDER BY cid DESC;")
    List<Course> selectByMoTeacher(String teacher);



    @Select("select * from `course` where cid = #{cid} order by cid desc")
    List<Course> selectByCid(Integer cid);




    @Update("UPDATE course SET likenum = #{likenum} WHERE cid = #{cid}")
    void updateLikenum(Integer likenum, Integer cid);




    @Update("UPDATE course SET pernum = #{pernum} WHERE cid = #{cid}")
    void updatePernum(Integer pernum, Integer cid); // 修改参数绑定到正确位置
    @Select("SELECT * FROM course where uid =#{uid} ORDER BY cid DESC;")
    List<Course> selectByUid(Integer uid);
//    @Select("Select * from 'course'")
//    static List<CourseInformation> selectAll() ;

}
