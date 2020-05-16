package com.gupaoedu.mebatis;

import com.gupaoedu.mebatis.mapper.Blog;

import java.sql.*;

public class MyExecutor {
    public Object query(String sql, Object parameter) {
        Connection conn = null;
        Statement statement = null;
        Blog blog = new Blog();

        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 打开连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC&useSSL=false", "root", "12111124");

            // 执行查询
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(String.format(sql, parameter));

            // 获取结果集
            while (rs.next()) {
                Integer bid = rs.getInt("bid");
                String name = rs.getString("name");
                Integer authorId = rs.getInt("author_id");
                blog.setAuthorId(authorId);
                blog.setBid(bid);
                blog.setName(name);
            }
            System.out.println(blog);

            rs.close();
            statement.close();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e ) {
            e.printStackTrace();
        } finally {
            try {
                if(statement!=null) {
                    statement.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if(conn!=null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return null;
    }
}
