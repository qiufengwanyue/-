package com.example.sharecoursebehind.mapper;

import com.example.sharecoursebehind.entity.Time;
import com.example.sharecoursebehind.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TimeMapper {
    @Insert("insert into `time`(cid,date,`rank`) values (#{cid},#{date},#{rank})")
    void insert(Time time);

    @Select("select * from `time` where date = #{date} and `rank` = #{rank} order by cid desc")
    Time selectByTime(String date,Integer rank);

    @Select("SELECT t.* FROM course c JOIN `time` t ON c.cid = t.cid WHERE c.area = #{area}  AND t.date = #{date}  AND t.`rank` = #{rank} LIMIT 1;")
    Time selectCheck(String area,String date,Integer rank);
}
