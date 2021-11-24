package com.yang.db;

import com.yang.common.JDBCUtil;
import com.yang.domain.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
@Repository
public class PostDAO {
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    private String INSERT_POST = "INSERT INTO POST "
            + "(POST_ID, CATEGORY_ID, TITLE, CONTENT, CREATED_DATE)"
            + "VALUES ((select nvl(max(CATEGORY_ID), 0) +1 from POST), ?, ?, ?, CURRENT_TIMESTAMP())";

    public void insertPost(PostVO vo) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(INSERT_POST);
            stmt.setInt(1, vo.getCategoryId());
            stmt.setString(2, vo.getTitle());
            stmt.setString(3, vo.getContent());
            int affectedRows = stmt.executeUpdate();
            log.info("InsertPost excuted. {} rows affected.", affectedRows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }
}
