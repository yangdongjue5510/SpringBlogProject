package com.yang.db;

import com.yang.common.JDBCUtil;
import com.yang.domain.BlogVO;
import com.yang.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogDAO {
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    private final String GET_BLOG_LIST = "SELECT * FROM BLOG";

    public List<BlogVO> getBlogList(){
        List<BlogVO> list = new ArrayList<>();
        conn = JDBCUtil.getConnection();
        try {
            stmt = conn.prepareStatement(GET_BLOG_LIST);
            rs = stmt.executeQuery();
            while (rs.next()){
                BlogVO blog = new BlogVO();
                blog.setBlogId(rs.getInt("BLOG_ID"));
                blog.setUserId(rs.getInt("USER_ID"));
                blog.setStatus(rs.getString("STATUS"));
                blog.setTag(rs.getString("TAG"));
                blog.setTitle(rs.getString("TITLE"));
                blog.setCntDisplayPost(rs.getInt("CNT_DISPLAY_POST"));
                list.add(blog);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return list;
    }


}
