package org.dyw.simple.framework.orm.core.impl;

import org.dyw.simple.framework.orm.core.ConnectionPool;
import org.dyw.simple.framework.orm.po.DSimpleDatabaseConfigInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库池
 * */
public class ConnectionPoolImpl implements ConnectionPool {
    private DSimpleDatabaseConfigInfo dSimpleDatabaseConfigInfo;
    public ConnectionPoolImpl(DSimpleDatabaseConfigInfo dSimpleDatabaseConfigInfo){
        this.dSimpleDatabaseConfigInfo=dSimpleDatabaseConfigInfo;
        try {
            Class.forName(dSimpleDatabaseConfigInfo.getDiver()); //执行驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // con = DriverManager.getConnection(url, username, password); //获取连接
    }

    @Override
    public Connection getConnection() {
        Connection connection=null;
        try {
            connection=DriverManager.getConnection(dSimpleDatabaseConfigInfo.getUrl(),
                    dSimpleDatabaseConfigInfo.getAccount(),
                    dSimpleDatabaseConfigInfo.getPassword());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            return connection;
        }
    }
}