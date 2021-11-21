package org.dyw.simple.framework.orm.annotation;


import java.lang.annotation.*;

/**
 * 定义查询sql的注解
 * */
@Repeatable(DSimpleDao.class)
public @interface DSimpleSql {
    String name();
    String sql();
    DSimpleSqlType sqlType();
    DSimpleSqlResultType resultType();
}
