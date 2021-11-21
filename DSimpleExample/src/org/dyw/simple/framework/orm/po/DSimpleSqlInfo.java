package org.dyw.simple.framework.orm.po;

import org.dyw.simple.framework.orm.annotation.DSimpleSqlResultType;
import org.dyw.simple.framework.orm.annotation.DSimpleSqlType;

public class  DSimpleSqlInfo {
    private String name;
    private String sql;
    private DSimpleSqlType sqlType;
    private DSimpleSqlResultType resultType;

    public DSimpleSqlInfo(String name, String sql, DSimpleSqlType sqlType, DSimpleSqlResultType resultType) {
        this.name = name;
        this.sql = sql;
        this.sqlType = sqlType;
        this.resultType = resultType;
    }
    public DSimpleSqlResultType getResultType() {
        return resultType;
    }

    public DSimpleSqlType getSqlType() {
        return sqlType;
    }
    public String getSql() {
        return sql;
    }
    public String getName() {
        return name;
    }
}
