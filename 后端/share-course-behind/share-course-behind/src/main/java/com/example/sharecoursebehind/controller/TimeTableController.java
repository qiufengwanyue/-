package com.example.sharecoursebehind.controller;

import com.example.sharecoursebehind.common.Result;
import com.example.sharecoursebehind.entity.TimeTable;
import com.example.sharecoursebehind.service.TimeTableService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController()
@RequestMapping("/TimeTable")
public class TimeTableController {
    @Resource
    TimeTableService timeTableService;

    @PostMapping("/add")
    public Result add(@RequestBody TimeTable timeTable){
        timeTableService.insertTimeTable(timeTable);
        return Result.success();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Map<String, String> data) {
        String changeName = data.get("changeName");
        String course = data.get("course");
        Integer uid = Integer.valueOf(data.get("uid"));



//        String timeTableList = timeTableService.selectByUid(uid, changeName);
//
//
//        System.out.println("asd");
//        System.out.println(timeTableList);
//        System.out.println("asd");
//

//        // 使用StringBuilder构建字符串
//        StringBuilder stringBuilder = new StringBuilder();
//        for (TimeTable timeTable : timeTableList) {
//            if (timeTable != null) { // 添加null检查
//                stringBuilder.append(timeTable.toString()).append("\n"); // 假设TimeTable类有合适的toString方法
//            }
//        }
//
//        // 打印字符串
//        String timeTableString = stringBuilder.toString();
//        System.out.println(timeTableString);
        timeTableService.updateTimeTable(changeName, course, uid);

            // 如果时间表列表为空，则执行更新操作
//            if (timeTableList ==null) {
//                timeTableService.updateTimeTable(changeName, course, uid);
//            }
//
//            // 返回时间表列表
            return Result.success();
    }


//        @PostMapping("/selectByUid")
//        public Result selectByUid(@RequestBody Map<String, String> params) {
//            Integer uid = Integer.valueOf(params.get("uid"));
//            String changeName = params.get("changeName");
//            List<TimeTable> timeTableList = timeTableService.selectByUid(uid, changeName);
//            return Result.success(timeTableList);
//        }



    @PostMapping("/selectByUserUid")
    public Result selectByUserUid(@RequestBody Map<String, Integer> params){
        Integer uid = params.get("uid");
        List<TimeTable> timeTableList = timeTableService.selectByUserUid(uid);
        return Result.success(timeTableList);
    }


    @PostMapping("/updateByUidAndChangeName")
    public Result updateByUidAndChangeName(@RequestBody Map<String, String> params) {
        Integer uid = Integer.valueOf(params.get("uid"));
        String changeName = params.get("changeName");
        boolean success = timeTableService.updateByUidAndChangeName(uid, changeName );
        if (success) {
            return Result.success("删除成功");
        } else {
            return Result.error("删除失败");
        }
    }


}
