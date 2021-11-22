package com.yang.service;

import com.yang.domain.BoardVO;

import java.util.List;

public interface BoardService {
    List<BoardVO> getBoardList();

    List<BoardVO> searchBoardList(String searchCondition, String searchKeyword);
}
