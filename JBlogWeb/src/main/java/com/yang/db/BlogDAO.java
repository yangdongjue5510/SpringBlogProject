package com.yang.db;

import com.yang.common.JDBCUtil;
import com.yang.domain.BlogVO;
import com.yang.domain.UserVO;
import com.yang.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@Repository
public class BlogDAO {
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    private final String GET_BLOG_LIST = "SELECT * FROM BLOG";
    private final String GET_BLOG_BY_USER_ID = "SELECT * FROM BLOG WHERE USER_ID = ?";
    private final String INSERT_BLOG = "INSERT INTO BLOG (BLOG_ID, TITLE, TAG, CNT_DISPLAY_POST, STATUS, USER_ID)"
            + "VALUES ((select nvl(max(BLOG_ID), 0) +1 from BLOG), ?, ?, ?, ?, ?)";
    public List<BlogVO> getBlogList(){
        List<BlogVO> list = new ArrayList<>();
        conn = JDBCUtil.getConnection();
        try {
            stmt = conn.prepareStatement(GET_BLOG_LIST);
            rs = stmt.executeQuery();
            while (rs.next()){
                BlogVO blog = setBlogVO();
                list.add(blog);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return list;
    }

    public BlogVO getBlog(UserVO vo){
        BlogVO blog = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(GET_BLOG_BY_USER_ID);
            stmt.setInt(1, vo.getUserId());
            rs = stmt.executeQuery();

            while (rs.next()){
                blog = setBlogVO();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return blog;
    }

    public void insertBlog(String blogTitle, UserVO vo) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(INSERT_BLOG);
            stmt.setString(1, blogTitle);
            stmt.setString(2, "Welcome to JBlog.");
            stmt.setInt(3, 5);
            stmt.setString(4, "OPEN");  //운영 대신 OPEN.
            stmt.setInt(5, vo.getUserId());
            int affectedRows = stmt.executeUpdate();
            log.info("insertBlog query execute. {} rows affected", affectedRows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    public BlogVO setBlogVO() throws SQLException {
        BlogVO blog = new BlogVO();
        blog.setBlogId(rs.getInt("BLOG_ID"));
        blog.setUserId(rs.getInt("USER_ID"));
        blog.setStatus(rs.getString("STATUS"));
        blog.setTag(rs.getString("TAG"));
        blog.setTitle(rs.getString("TITLE"));
        blog.setCntDisplayPost(rs.getInt("CNT_DISPLAY_POST"));
        return blog;
    }
}
