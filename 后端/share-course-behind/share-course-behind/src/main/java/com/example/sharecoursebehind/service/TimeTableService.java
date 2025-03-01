package com.example.sharecoursebehind.service;

import com.example.sharecoursebehind.entity.TimeTable;
import com.example.sharecoursebehind.mapper.TimeTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeTableService {
    @Autowired
    TimeTableMapper timeTableMapper;

    public void insertTimeTable(TimeTable timeTable) {
        timeTableMapper.insert(timeTable);
    }

    public void updateTimeTable(String changeName, String course, Integer uid) {
        timeTableMapper.updateTimeTable(changeName, course, uid);
    }

    public List<TimeTable> selectByUserUid(Integer uid) {
        return timeTableMapper.selectByUserUid(uid);
    }

    public String selectByUid(Integer uid, String changeName) {
     return  timeTableMapper.selectByUid(uid,changeName) ;

    }

    public boolean updateByUidAndChangeName(Integer uid, String changeName) {
        int rowsAffected = timeTableMapper.updateByUidAndChangeName(uid, changeName);
        return rowsAffected > 0;
    }
}
