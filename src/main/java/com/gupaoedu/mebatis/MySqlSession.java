package com.gupaoedu.mebatis;

public class MySqlSession {
    private MyConfiguration configuration;
    private MyExecutor executor;

    public MySqlSession(MyConfiguration configuration, MyExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T getMapper(Class clazz) {
        // 根据配置文件，创建代理类MapperProxy
        return configuration.getMapper(clazz, this);
    }

    public Object selectOne(String statmentId, Object parameter) {
        String sql = MyConfiguration.sqlMappings.getString(statmentId);

        if (sql!=null&&!"".equals(sql)) {
            return executor.query(sql, parameter);
        }
        return null;
    }
}
