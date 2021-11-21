package com.dyw.dao;

import org.dyw.simple.framework.orm.annotation.DSimpleDao;
import org.dyw.simple.framework.orm.annotation.DSimpleSql;
import org.dyw.simple.framework.orm.annotation.DSimpleSqlResultType;
import org.dyw.simple.framework.orm.annotation.DSimpleSqlType;
/**
 * @auther dyw
 * @vesion 1.0.0
 * 这是一个标准的DSimpleDao，我们认为一个Dao是sql语句的集合.
 * 利用@DSimpleSql定义SQL，并在以后通过name调用它.
 * DSimpleFramework的ORM理念是，将数据抽象成 对象 对象哈希表 对象链表  空
 * 其中
 * 对象对应单数值 对应 数据项
 * 对象哈希表 对应 数据列
 * 对象链表 是 对象哈希表的集合 对应 数据表
 * 注意：本框架的黑魔法是 DSimpleSql可以定义到任何类，接口，对象的上面.
 *      任何地方的SQL都能被你调用
 *                       ——不过考虑到分层，我不推荐你这么做.
 * */
@DSimpleDao({
        @DSimpleSql(
                name = "userDao.getPassword",
                sql = "select password from user where name=?",
                sqlType = DSimpleSqlType.Query,
                resultType = DSimpleSqlResultType.Object
        )
})
public interface UserDao { }
