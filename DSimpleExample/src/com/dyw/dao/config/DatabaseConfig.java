package com.dyw.dao.config;

import org.dyw.simple.framework.orm.annotation.DSimpleDatabaseConfig;

/**
 * @auther dyw
 * @version 1.0.0
 * 用作配置数据库 不存在则无法使用ORM功能.
 * 记得导入相关的数据库驱动.
 * 你可以把这个注解放在任何地方.
 * */
@DSimpleDatabaseConfig(
        driver = "com.mysql.cj.jdbc.Driver",
        url = "jdbc:mysql://localhost:3306/dsfe",
        account = "root",
        password = "root"
)
public interface DatabaseConfig { }
