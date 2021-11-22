package com.yang.service;

import com.yang.db.BoardDAO;
import com.yang.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{
    @Autowired
    BoardDAO boardDAO;

    @Override
    public List<BoardVO> getBoardList() {
        return boardDAO.boardList();
    }
}
