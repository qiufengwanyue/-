package com.example.sharecoursebehind.controller;

import com.example.sharecoursebehind.common.Result;
import com.example.sharecoursebehind.entity.Time;
import com.example.sharecoursebehind.service.TimeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController()
@RequestMapping("/time")
public class TimeController {
    @Resource
    TimeService timeService;

    @GetMapping("/select")
    public Result selectAll(){
        List<Time> timeList= timeService.selectAll();
        return Result.success(timeList);
    }

    @GetMapping("/selectByCid/{cid}")
    public Result selectByCoursename(@PathVariable Integer cid){
        List<Time> timeList= timeService.selectByCid(cid);
        return Result.success(timeList);
    }

    @GetMapping("/selectByIid/{iid}")
    public Result selectByIid(@PathVariable Integer iid){
        List<Time> timeList= timeService.selectByIid(iid);
        return Result.success(timeList);
    }
}
