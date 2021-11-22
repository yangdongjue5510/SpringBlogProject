package com.yang.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BoardVO {

    /*
    PK = seq
    FK = categoryName
     */

    private int seq;
    private String title;
    private String content;
    private String writer;
    private String category;
    private Date regDate;
    private int cnt;
}