package com.yang;

import com.yang.domain.BlogVO;
import com.yang.domain.UserVO;
import com.yang.service.BlogService;
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
}
