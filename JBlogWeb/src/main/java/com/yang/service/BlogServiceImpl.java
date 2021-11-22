package com.yang.service;

import com.yang.db.BlogDAO;
import com.yang.domain.BlogVO;
import com.yang.domain.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    BlogDAO blogDAO;


    @Override
    public List<BlogVO> getBlogList() {
        List<BlogVO> list = blogDAO.getBlogList();
        return list;
    }

    @Override
    public BlogVO getBlog(UserVO vo) {
        return blogDAO.getBlog(vo);
    }

    @Override
    public void insertBlog(String blogTitle, UserVO vo) {
        blogDAO.insertBlog(blogTitle, vo);
    }
}
