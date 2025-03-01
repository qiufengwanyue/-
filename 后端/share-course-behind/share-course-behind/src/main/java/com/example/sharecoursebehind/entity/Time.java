package com.example.sharecoursebehind.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class Time {
    private Integer iid;
    private Integer cid;
    private String date;
    private Integer rank;
}
