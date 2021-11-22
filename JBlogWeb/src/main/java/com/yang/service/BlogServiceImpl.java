package com.yang.service;

import com.yang.db.BlogDAO;
import com.yang.domain.BlogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    BlogDAO blogDAO;


    @Override
    public List<BlogVO> getBlog() {
        List<BlogVO> list = blogDAO.getBlogList();
        return list;
    }
}
