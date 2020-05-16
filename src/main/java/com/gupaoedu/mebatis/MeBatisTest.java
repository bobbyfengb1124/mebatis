package com.gupaoedu.mebatis;

import com.gupaoedu.mebatis.mapper.BlogMapper;

public class MeBatisTest {
    public static void main(String[] args) {
        MySqlSession sqlSession = new MySqlSession(new MyConfiguration(), new MyExecutor());
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        blogMapper.selectBlogById(1);
    }
}
