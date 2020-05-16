package com.gupaoedu.mebatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyMapperProxy implements InvocationHandler {
    MySqlSession sqlSession;

    MyMapperProxy(MySqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
       String mapperInterface = method.getDeclaringClass().getName();
       String methodName = method.getName();
       String statmentId = mapperInterface+"."+methodName;

        return sqlSession.selectOne(statmentId, objects[0]);
    }
}
