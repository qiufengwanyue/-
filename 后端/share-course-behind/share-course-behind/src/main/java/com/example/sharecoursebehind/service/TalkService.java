package com.example.sharecoursebehind.service;

import com.example.sharecoursebehind.entity.Talk;
import com.example.sharecoursebehind.entity.User;
import com.example.sharecoursebehind.mapper.TalkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalkService {
    @Autowired
    TalkMapper talkMapper;
    public List<Talk> selectAll(Integer cid) {
        return talkMapper.selectAll(cid);
    }

    public void insertTalk(Integer uid, String content, Integer cid) {
        talkMapper.insertTalk(uid, content, cid);
    }

    public List<User> selectByUid(Integer uid) {
        return  talkMapper. selectByUid(uid);
    }
}
