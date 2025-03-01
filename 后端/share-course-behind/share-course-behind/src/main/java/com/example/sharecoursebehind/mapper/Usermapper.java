package com.example.sharecoursebehind.mapper;

import com.example.sharecoursebehind.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface Usermapper {
    @Insert("insert into `user`(username,password,age,grade,ucolloge,upicture,upnum,attnum,power) values (#{username},#{password}," +
            "#{age},#{grade},#{ucolloge},#{upicture},#{upnum},#{attnum},#{power})")
    void insert (User user);

    @Select("select * from `user` where username = #{username} order by uid desc")
    User selectByUsername(String username);

    @Select("select * from `user` where uid = #{uid} order by uid desc")
    User selectByUid(Integer uid);

    @Update("update `user` set username=#{username},password=#{password},age=#{age},grade=#{grade},ucolloge=#{ucolloge},upicture=#{upicture},power=#{power} where uid=#{uid}")
    void changeByUid(User user);

    @Update("update `user` set power=1 where username=#{username}")
    void up(String username);

    @Update("update `user` set power=0 where username=#{username}")
    void down(String username);

    @Select("SELECT * FROM `user` WHERE power=1;")
    List<User> selectByPower();
}
