package com.yang.db;

import com.yang.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<BoardVO> boardList(){
        String query = "SELECT * FROM BOARD";
        List<BoardVO> list = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(BoardVO.class));
        return list;
    }
    //public List<BoardVO> searchBoardList(String SearchCondtion, String SearchKeyword){

    //}
}
