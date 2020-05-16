package com.gupaoedu.mebatis;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

public class MyConfiguration {

    public static final ResourceBundle sqlMappings;

    static {
        sqlMappings = ResourceBundle.getBundle("v1sql");
    }

    public <T> T getMapper(Class clazz, MySqlSession mySqlSession) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class[]{clazz},
                new MyMapperProxy(mySqlSession));
    }
}
