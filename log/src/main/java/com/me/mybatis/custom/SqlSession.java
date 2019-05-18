package com.me.mybatis.custom;

import java.lang.reflect.Proxy;

public class SqlSession {

    public <T> T getMapper(Class<T> clazz) {

        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{ clazz }, new MapperProxy());
    }

}
