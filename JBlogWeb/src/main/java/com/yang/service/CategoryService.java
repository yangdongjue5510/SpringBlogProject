package com.yang.service;

import com.yang.domain.BlogVO;
import com.yang.domain.CategoryVO;

import java.util.List;

public interface CategoryService {
    void insertCategory(CategoryVO vo);

    List<CategoryVO> getCategoryList(BlogVO vo);
}
