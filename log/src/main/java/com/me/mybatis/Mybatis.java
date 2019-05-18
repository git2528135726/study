package com.me.mybatis;

import com.me.mybatis.dao.BlogMapper;
import com.me.mybatis.model.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 1、mybatis日志框架查找顺序：SLF4J、Apache Commons Logging、Log4j 2、Log4j、JDK logging
 * 2、如果环境提供了 Commons Logging 的私有实现，你的 Log4J 配置将被忽略，如spring-jcl的默认查找顺序为Log4j 2.x / SLF4J,jul
 */
public class Mybatis {

    public static void main(String[] args) {

        //System.setProperty("java.util.logging.config.file", JUL.class.getResource("/").getPath()+"logging.properties");

        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Blog blog = mapper.selectBlog(1);
            System.out.println(blog.getName());
        } finally {
            session.close();
        }

    }
}
