package com.example.sharecoursebehind.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class CourseTime {
    private Integer iid;
    private Integer cid;
    private String date;
    private Integer rank;
    private Integer uid;
    private String coursename;
    private String teacher;
    private String ccolloge;
    private String area;
    private Integer pernum;
    private Integer roomnum;
    private String introduce;
    private String warn;
    private String sort1;
    private String sort2;
    private String sort3;
    private String cpicture;
    private Integer reservenum;
    private Integer cumreservenum;
    private Integer score;
    private Integer likenum;
    private Integer day;
}
