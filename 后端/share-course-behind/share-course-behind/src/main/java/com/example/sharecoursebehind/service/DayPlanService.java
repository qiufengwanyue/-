package com.example.sharecoursebehind.service;


import com.example.sharecoursebehind.entity.DayPlan;
import com.example.sharecoursebehind.mapper.DayPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DayPlanService {

    @Autowired
    DayPlanMapper dayPlanMapper;
    public DayPlan update(DayPlan dayPlan) {
        dayPlanMapper.changeByUid(dayPlan);
        DayPlan dbDayPlan = dayPlanMapper.selectByUid(dayPlan.getUid());
        return dbDayPlan;
    }

    public DayPlan select(Integer uid) {
        DayPlan dbDayPlan = dayPlanMapper.selectByUid(uid);
        return dbDayPlan;
    }
}
