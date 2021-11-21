package org.dyw.simple.framework.orm.core;

import java.sql.Connection;
/**
 * 数据库连接池的接口
 * */
public interface ConnectionPool {
    public Connection getConnection();
}
