package com.yang.service;

import com.yang.domain.BlogVO;
import com.yang.domain.UserVO;

import java.util.List;

public interface BlogService {
    public List<BlogVO> getBlogList();

    public BlogVO getBlog(UserVO vo);
}
