package com.me.mybatis.custom;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MapperProxy implements InvocationHandler, Serializable {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        List<String> lst = new ArrayList<String>();
        lst.add("string 1");
        lst.add("string 2");
        lst.add("string 3");
        return lst;
    }
}
