package com.yang.domain;

import java.util.Date;

public class UserVO {

    /*
    PK = userId
    FK = blogName
     */
    private String userId;
    private String password;
    private String username;
    private Date regDate;
    private String blogName;
}