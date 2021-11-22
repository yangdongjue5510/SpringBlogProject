package com.yang;

import com.yang.domain.BoardVO;
import com.yang.domain.UserVO;
import com.yang.service.BoardService;
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

    @Autowired
    BoardService boardService;

    @Test
    void getUserListTest() {
        List<UserVO> userList = userService.getUserList();
        assertEquals(2, userList.size());
    }

    @Test
    void getBoardListTest() {
        List<BoardVO> boardList = boardService.getBoardList();
        assertEquals(1, boardList.size());
    }

    @Test
    void searchBoardListTest() {
        List<BoardVO> boardList = boardService.searchBoardList("title", "hello");
        assertEquals(1, boardList.size());
    }

}
