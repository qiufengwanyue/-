package com.example.sharecoursebehind.service;

import com.example.sharecoursebehind.entity.Time;
import com.example.sharecoursebehind.mapper.TimeMapperL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeService {
    @Autowired
    TimeMapperL timeMapperL;
    public List<Time> selectAll() {
        return timeMapperL.selectAll();
    }

    public List<Time> selectByCid(Integer cid) {
        return timeMapperL.selectByCid(cid);
    }

    public List<Time> selectByIid(Integer iid) {
        return timeMapperL.selectByIid(iid);
    }
}
