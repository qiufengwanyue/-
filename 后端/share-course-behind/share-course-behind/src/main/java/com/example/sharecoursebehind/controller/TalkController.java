package com.example.sharecoursebehind.controller;

import com.example.sharecoursebehind.common.Result;
import com.example.sharecoursebehind.entity.Course;
import com.example.sharecoursebehind.entity.Talk;
import com.example.sharecoursebehind.entity.TimeTable;
import com.example.sharecoursebehind.entity.User;
import com.example.sharecoursebehind.service.CourseServiceL;
import com.example.sharecoursebehind.service.TalkService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController()
@RequestMapping("/talk")
public class TalkController {
    @Resource
    TalkService talkService;
    @GetMapping("/select/{cid}")
    public Result selectAll(@PathVariable Integer cid){
        List<Talk> talkList= talkService.selectAll(cid);
        return Result.success(talkList);
    }

    // 后端代码修改
    @GetMapping("/selectByUid/{uid}")
    public ResponseEntity<Result> selectByUid(@PathVariable Integer uid) {
        try {
            List<User> usersList = talkService.selectByUid(uid);
            return ResponseEntity.ok(Result.success(usersList));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Result.error("获取用户信息失败"));
        }
    }

    @PostMapping("/add")
    public Result add(@RequestBody Map<String, Object> requestMap) {
        try {
            Integer uid = (Integer) requestMap.get("uid");
            Integer cid = (Integer) requestMap.get("cid");
            String content = (String) requestMap.get("content");

            if (uid != null && cid != null) { // 添加对cid是否为null的检查
                talkService.insertTalk(uid, content, cid);
                return Result.success();
            } else {
                return Result.error("UID or CID cannot be null");
            }
        } catch (ClassCastException | NullPointerException ex) {
            return Result.error("Invalid input data"); // 捕获并处理可能出现的异常
        }
    }




}

