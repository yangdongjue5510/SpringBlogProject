package com.yang;

import com.yang.domain.BlogVO;
import com.yang.domain.CategoryVO;
import com.yang.domain.PostVO;
import com.yang.domain.UserVO;
import com.yang.service.BlogService;
import com.yang.service.CategoryService;
import com.yang.service.PostService;
import com.yang.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class JBlogWebApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    PostService postService;

    @Test
    void getUserTest(){
        UserVO user = userService.getUser("user", "user123");
        assertNotNull(user);
    }

    @Test
    void getBlogList() {
        List<BlogVO> list = blogService.getBlogList();
        assertEquals(1, list.size());
    }

    @Test
    void getBlog() {

        BlogVO blog = blogService.getBlog(1);
        assertNotNull(blog);
    }

    @Test
    void insertBlog() {
        UserVO user = new UserVO();
        user.setUserId(2);
        blogService.insertBlog("TestBlog", user);
        assertEquals(2, blogService.getBlogList().size());
    }

    @Test
    void insertCategory() {
        CategoryVO category = new CategoryVO();
        category.setBlogId(1);
        category.setCategoryName("TEST CATEGORY");
        category.setDisplayType("TITLE ONLY");
        category.setCntDisplayPost(4);
        //category.setDescription("test.");
        categoryService.insertCategory(category);

    }

    @Test
    void searchBlogTitle() {
        List<BlogVO> list = blogService.searchBlog("TITLE", "test");
        assertEquals(2, list.size());
    }

    @Test
    void deleteBlog() {
        blogService.deleteBlog(2);
        assertEquals(1, blogService.getBlogList().size());
    }

    @Test
    void getCategoryList() {
        BlogVO blogVO = new BlogVO();
        blogVO.setBlogId(1);
        List<CategoryVO> categoryList = categoryService.getCategoryList(blogVO);
        assertEquals(1, categoryList.size());
    }

    @Test
    void getCategory() {
        CategoryVO category = categoryService.getCategory(2);
        int blogId = category.getBlogId();
        assertEquals(2, blogId);
    }

    @Test
    void insertPost() {
        PostVO post = new PostVO();
        post.setCategoryId(1);
        post.setContent("testing...");
        post.setTitle("test");
        postService.insertPost(post);
    }
}
