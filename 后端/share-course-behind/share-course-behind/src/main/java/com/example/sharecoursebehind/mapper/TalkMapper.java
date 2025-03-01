package com.example.sharecoursebehind.mapper;

import com.example.sharecoursebehind.entity.Course;
import com.example.sharecoursebehind.entity.Talk;
import com.example.sharecoursebehind.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TalkMapper {
    @Select("SELECT * FROM talk where cid =#{cid} ORDER BY cid DESC;")
    List<Talk> selectAll(Integer cid);
    @Insert("INSERT INTO talk (uid, cid, content) VALUES (#{uid}, #{cid}, #{content})")
    void insertTalk(Integer uid, String content, Integer cid);
    @Select("SELECT * FROM user where uid =#{uid};")
    List<User> selectByUid(Integer uid);
}
