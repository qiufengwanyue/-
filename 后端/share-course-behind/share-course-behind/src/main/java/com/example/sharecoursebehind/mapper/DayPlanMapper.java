package com.example.sharecoursebehind.mapper;

import com.example.sharecoursebehind.entity.DayPlan;
import com.example.sharecoursebehind.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DayPlanMapper {
    @Insert("insert into `dayplan`(uid) values (#{uid})")
    void newDayPlan (Integer uid);

    @Update("update `dayplan` set p1=#{p1},p2=#{p2},p3=#{p3},p4=#{p4},p5=#{p5},p6=#{p6},p7=#{p7},p8=#{p8},p9=#{p9} where uid=#{uid}")
    void changeByUid(DayPlan dayPlan);

    @Select("select * from `dayplan` where uid = #{uid} order by uid desc")
    DayPlan selectByUid(Integer uid);
}
