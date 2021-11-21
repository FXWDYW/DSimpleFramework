package org.dyw.simple.framework.orm.core.extend;

import org.dyw.simple.framework.orm.core.ConnectionPool;
import org.dyw.simple.framework.orm.core.DaoBase;
import org.dyw.simple.framework.orm.core.impl.ConnectionPoolImpl;
import org.dyw.simple.framework.orm.po.DSimpleDatabaseConfigInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DSimpleDaoBase extends DaoBase {
    ConnectionPool connectionPool;
    public DSimpleDaoBase(DSimpleDatabaseConfigInfo dSimpleDatabaseConfigInfo){
        this.connectionPool=new ConnectionPoolImpl(dSimpleDatabaseConfigInfo);
    }
    //操作数据库
    @Override
    public void Manipulation(String sql, Object... args) {
        System.out.println("DSimple->ORM->Execute:"+sql);
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection=connectionPool.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            for(int i=0;i<args.length;i++) {
                preparedStatement.setObject(i+1, args[i]);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    @Override
    public <E> E queryForValue(String sql, Object... args) {
        System.out.println("DSimple->ORM->Execute:"+sql);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }

            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return (E) resultSet.getObject(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                resultSet.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Map<String, Object> queryForModel(String sql, Object... args) {
        System.out.println("DSimple->ORM->Execute:"+sql);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Map<String,Object> map=new HashMap<>();
        try {
            connection = connectionPool .getConnection();
            preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }

            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
            if(resultSet.next()) {
                for(int i=0;i<resultSetMetaData.getColumnCount();i++) {
                    map.put(resultSetMetaData.getColumnName(i+1), resultSet.getObject(i+1));
                }
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
                try {
                    connection.close();
                    preparedStatement.close();
                    resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return map;
    }

    @Override
    public List<Map<String, Object>> queryForList(String sql, Object... args) {
        System.out.println("DSimple->ORM->Execute:"+sql);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Map<String,Object>> list=new ArrayList<>();
        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
            while(resultSet.next()) {
                Map<String,Object> map=new HashMap<>();
                for(int i=0;i<resultSetMetaData.getColumnCount();i++) {
                    map.put(resultSetMetaData.getColumnName(i+1), resultSet.getObject(i+1));
                }
                list.add(map);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return list;
    }
}
