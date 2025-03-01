package com.example.sharecoursebehind.mapper;

import com.example.sharecoursebehind.entity.WeekPlan;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface WeekPlanMapper {

    @Insert("insert into `weekplan`(uid) values (#{uid})")
    void newWeekPlan (Integer uid);


    @Update("update `weekplan` set mon=#{mon},tue=#{tue},wed=#{wed},thu=#{thu},fri=#{fri},sat=#{sat},sun=#{sun} where uid=#{uid}")
    void changeByUid(WeekPlan weekPlan);

    @Select("select * from `weekplan` where uid = #{uid} order by uid desc")
    WeekPlan selectByUid(Integer uid);
}
