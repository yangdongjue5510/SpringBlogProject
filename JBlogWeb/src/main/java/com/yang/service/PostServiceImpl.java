package com.yang.service;

import com.yang.db.PostDAO;
import com.yang.domain.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostDAO postDAO;

    @Override
    public void insertPost(PostVO vo) {
        postDAO.insertPost(vo);
    }
}
