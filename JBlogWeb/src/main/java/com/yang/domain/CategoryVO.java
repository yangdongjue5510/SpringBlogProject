package com.yang.domain;

public class CategoryVO {
    /*
    PK = categoryName
    FK = blogName
     */

    private String categoryName;
    private String displayType;
    private int postCount;
    private String description;
    private boolean deletable;
    private String blogName;
}