package org.dyw.simple.framework.orm.core;

import java.util.List;
import java.util.Map;

/**
 * 数据库操作的基础接口.
*/
public abstract class DaoBase {
    public abstract void Manipulation(String sql,Object...args);
    public abstract  <E>E queryForValue(String sql, Object ...args);
    public abstract Map<String,Object> queryForModel(String sql, Object ...args);
    public abstract List<Map<String,Object>> queryForList(String sql, Object ...args);
}
