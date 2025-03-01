package com.example.sharecoursebehind.service;

import com.example.sharecoursebehind.entity.DayPlan;
import com.example.sharecoursebehind.entity.WeekPlan;
import com.example.sharecoursebehind.mapper.DayPlanMapper;
import com.example.sharecoursebehind.mapper.WeekPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeekPlanService {

    @Autowired
    WeekPlanMapper weekPlanMapper;

    public WeekPlan update(WeekPlan weekPlan) {
        weekPlanMapper.changeByUid(weekPlan);
        WeekPlan dbWeekPlan = weekPlanMapper.selectByUid(weekPlan.getUid());
        return dbWeekPlan;
    }

    public WeekPlan select(Integer uid) {
        WeekPlan dbWeekPlan = weekPlanMapper.selectByUid(uid);
        return dbWeekPlan;
    }
}
