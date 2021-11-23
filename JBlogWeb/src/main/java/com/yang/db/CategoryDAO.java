package com.yang.db;

import com.yang.common.JDBCUtil;
import com.yang.domain.BlogVO;
import com.yang.domain.CategoryVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class CategoryDAO {
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    private String INSERT_CATEGORY = "INSERT INTO CATEGORY "
            + "(CATEGORY_ID, BLOG_ID, CATEGORY_NAME, DISPLAY_TYPE, CNT_DISPLAY_POST, DESCRIPTION, CREATED_DATE)"
            + "VALUES ((select nvl(max(CATEGORY_ID), 0) +1 from CATEGORY), ?, ?, ?, ?, ?, CURRENT_TIMESTAMP())";
    private String GET_CATEGORY_LIST_BY_BLOGID = "SELECT * FROM CATEGORY WHERE BLOG_ID = ?";

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

    public List<CategoryVO> getCategoryList(BlogVO vo){
        List<CategoryVO> list = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(GET_CATEGORY_LIST_BY_BLOGID);
            stmt.setInt(1, vo.getBlogId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(setCategoryVO());
            }
            log.info("getCategoryList execute.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
        return list;
    }

    public CategoryVO setCategoryVO() throws SQLException {
        CategoryVO category = new CategoryVO();
        category.setCategoryId(rs.getInt("CATEGORY_ID"));
        category.setBlogId(rs.getInt("BLOG_ID"));
        category.setCategoryName(rs.getString("CATEGORY_NAME"));
        category.setDisplayType(rs.getString("DISPLAY_TYPE"));
        category.setCntDisplayPost(rs.getInt("CNT_DISPLAY_POST"));
        category.setDescription(rs.getString("DESCRIPTION"));
        category.setCreatedDate(rs.getDate("CREATED_DATE"));
        category.setModifiedDate(rs.getTime("MODIFIED_DATE"));
        return category;
    }
}
