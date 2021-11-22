package com.yang;

import com.yang.domain.BlogVO;
import com.yang.domain.CategoryVO;
import com.yang.domain.UserVO;
import com.yang.service.BlogService;
import com.yang.service.CategoryService;
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
        UserVO user = new UserVO();
        user.setUserId(1);
        BlogVO blog = blogService.getBlog(user);
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
        category.setDescription("test.");
        categoryService.insertCategory(category);

    }
}
