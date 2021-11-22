package com.yang.db;

import com.yang.common.JDBCUtil;
import com.yang.domain.BoardVO;
import com.yang.domain.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public List<BoardVO> searchBoardList(String searchCondtion, String searchKeyword){
        String query = "SELECT * FROM BOARD" + " WHERE "+ searchCondtion + " = " +"'"+searchKeyword+"'";
        List<BoardVO> list = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(BoardVO.class));
        return list;
    }
}
