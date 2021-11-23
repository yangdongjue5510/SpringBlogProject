package com.yang.service;

import com.yang.db.BlogDAO;
import com.yang.db.CategoryDAO;
import com.yang.domain.BlogVO;
import com.yang.domain.CategoryVO;
import com.yang.domain.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    BlogDAO blogDAO;

    @Autowired
    CategoryDAO categoryDAO;


    @Override
    public List<BlogVO> getBlogList() {
        List<BlogVO> list = blogDAO.getBlogList();
        return list;
    }

    @Override
    public BlogVO getBlog(UserVO vo) {
        return blogDAO.getBlog(vo);
    }

    @Transactional
    @Override
    public void insertBlog(String blogTitle, UserVO vo) {
        blogDAO.insertBlog(blogTitle, vo);
        int userId = vo.getUserId();
        CategoryVO category = new CategoryVO();
        category.setCategoryName("분류없음");
        category.setBlogId(userId);
        category.setDisplayType("제목+내용");
        category.setCntDisplayPost(5);
        categoryDAO.insertCategory(category);
    }

    @Override
    public List<BlogVO> searchBlog(String searchCondition, String searchKeyword) {
        List<BlogVO> blogList = blogDAO.searchBlog(searchCondition, searchKeyword);
        return blogList;
    }

    @Override
    public void deleteBlog(int blogId) {
        blogDAO.deleteBlog(blogId);
    }

    @Override
    public void updateBlog(BlogVO vo) {
        blogDAO.updateBlog(vo);
    }


}
