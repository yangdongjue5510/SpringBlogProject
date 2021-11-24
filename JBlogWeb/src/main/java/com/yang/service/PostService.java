package com.yang.service;

import com.yang.domain.PostVO;

import java.util.List;

public interface PostService {
    void insertPost(PostVO vo);

    List<PostVO> getPostByCategoryId(int categoryId);

    List<PostVO> getPost(int blogId);
}
