package com.example.sharecoursebehind.controller;

import com.example.sharecoursebehind.common.Result;
import com.example.sharecoursebehind.entity.DayPlan;
import com.example.sharecoursebehind.service.DayPlanService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/dayplan")
public class DayPlanController {

    @Resource
    DayPlanService dayPlanService;

    @PostMapping("/updatedayplan")
    public Result updatedayplan(@RequestBody DayPlan dayPlan){
        dayPlan=dayPlanService.update(dayPlan);
        return Result.success(dayPlan);
    }

    @PostMapping("/selectdayplan")
    public Result selectdayplan(@RequestBody Integer uid){
        DayPlan dayPlan=dayPlanService.select(uid);
        return Result.success(dayPlan);
    }
}
