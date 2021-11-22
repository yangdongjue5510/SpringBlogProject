package com.yang.db;

import com.yang.common.JDBCUtil;
import com.yang.domain.CategoryVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Slf4j
@Repository
public class CategoryDAO {
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    private String INSERT_CATEGORY = "INSERT INTO CATEGORY "
            + "(CATEGORY_ID, BLOG_ID, CATEGORY_NAME, DISPLAY_TYPE, CNT_DISPLAY_POST, DESCRIPTION, CREATED_DATE)"
            + "VALUES ((select nvl(max(CATEGORY_ID), 0) +1 from CATEGORY), ?, ?, ?, ?, ?, CURRENT_TIMESTAMP())";

    public void insertCategory(CategoryVO vo){
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(INSERT_CATEGORY);
            stmt.setInt(1, vo.getBlogId());
            stmt.setString(2, vo.getCategoryName());
            stmt.setString(3, vo.getDisplayType());
            stmt.setInt(4, vo.getCntDisplayPost());
            stmt.setString(5, vo.getDescription());
            int affectedRows = stmt.executeUpdate();
            log.info("InsertCategory excuted. {} rows affected.", affectedRows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }
}
