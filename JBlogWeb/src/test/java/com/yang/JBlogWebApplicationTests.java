package com.yang;

import com.yang.domain.UserVO;
import com.yang.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JBlogWebApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        List<UserVO> userList = userService.getUserList();
        assertEquals(2, userList.size());
    }

}
