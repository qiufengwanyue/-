package com.example.sharecoursebehind.mapper;

import com.example.sharecoursebehind.entity.Time;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TimeMapperL {
    @Select("SELECT * FROM time")
    List<Time> selectAll();
    @Select("SELECT * FROM time where cid =#{cid}")
    List<Time> selectByCid(Integer cid);
    @Select("SELECT * FROM time where iid =#{iid}")
    List<Time> selectByIid(Integer iid);
}
