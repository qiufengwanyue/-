package com.example.sharecoursebehind.controller;

import com.example.sharecoursebehind.common.Result;
import com.example.sharecoursebehind.entity.DayPlan;
import com.example.sharecoursebehind.entity.WeekPlan;
import com.example.sharecoursebehind.service.DayPlanService;
import com.example.sharecoursebehind.service.WeekPlanService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/weekplan")
public class WeekPlanController {

    @Resource
    WeekPlanService weekPlanService;
    @PostMapping("/updateweekplan")
    public Result updateweekplan(@RequestBody WeekPlan weekPlan){
        weekPlan=weekPlanService.update(weekPlan);
        return Result.success(weekPlan);
    }

    @PostMapping("/selectweekplan")
    public Result selectweekplan(@RequestBody Integer uid){
        WeekPlan weekPlan=weekPlanService.select(uid);
        return Result.success(weekPlan);
    }
}
