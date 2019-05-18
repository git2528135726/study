package com.me.mybatis.custom;

import java.util.List;

public class CustomMybatisTest {

    public static void main(String[] args) {

        SqlSession sqlSession = new SqlSession();
        IMessage iMessage = sqlSession.getMapper(IMessage.class);
        List<String> lst = iMessage.queryList();
        System.out.println(lst);
    }
}
