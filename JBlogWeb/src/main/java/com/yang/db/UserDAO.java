package com.yang.db;

import com.yang.domain.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<UserVO> userVOList(){
        String query = "SELECT * FROM USERS";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<UserVO>(UserVO.class));
    }
}
