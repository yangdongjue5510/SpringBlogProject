package com.yang.service;

import com.yang.domain.BlogVO;
import com.yang.domain.UserVO;

import java.util.List;

public interface BlogService {
    List<BlogVO> getBlogList();

    BlogVO getBlog(UserVO vo);

    void insertBlog(String blogTitle, UserVO vo);
}
