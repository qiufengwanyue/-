package com.example.sharecoursebehind.mapper;

import com.example.sharecoursebehind.entity.TimeTable;


import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Mapper
public interface TimeTableMapper {

    @Insert("insert into timetable (uid, " +
            "course1, course2, course3, course4, course5, " +
            "course6, course7, course8, course9, course10, " +
            "course11, course12, course13, course14, course15, " +
            "course16, course17, course18, course19, course20, " +
            "course21, course22, course23, course24, course25, " +
            "course26, course27, course28, course29, course30, " +
            "course31, course32, course33, course34, course35) " +
            "values (#{uid}, " +
            "#{course1}, #{course2}, #{course3}, #{course4}, #{course5}, " +
            "#{course6}, #{course7}, #{course8}, #{course9}, #{course10}, " +
            "#{course11}, #{course12}, #{course13}, #{course14}, #{course15}, " +
            "#{course16}, #{course17}, #{course18}, #{course19}, #{course20}, " +
            "#{course21}, #{course22}, #{course23}, #{course24}, #{course25}, " +
            "#{course26}, #{course27}, #{course28}, #{course29}, #{course30}, " +
            "#{course31}, #{course32}, #{course33}, #{course34}, #{course35})")
    void insert(TimeTable timeTable);

    @Insert("insert into `timetable`(uid) values (#{uid})")
    void newTimeTable(Integer uid);



    @Update("UPDATE timetable SET ${changeName} = #{course} WHERE uid = #{uid}")
    void updateTimeTable(@Param("changeName") String changeName, @Param("course") String course, @Param("uid") Integer uid);
    @Select("SELECT * FROM timetable where uid = #{uid}")
    List<TimeTable> selectByUserUid(Integer uid);
    @Select("SELECT ${changeName} FROM timetable WHERE uid = #{uid}")
    String selectByUid(@Param("uid") Integer uid, @Param("changeName") String changeName);

    @Update("UPDATE timetable SET ${changeName} =null WHERE uid = #{uid}")
    int updateByUidAndChangeName(@Param("uid") int uid, @Param("changeName") String changeName);
}