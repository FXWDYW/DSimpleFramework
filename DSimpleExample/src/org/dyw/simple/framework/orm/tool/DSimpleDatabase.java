package org.dyw.simple.framework.orm.tool;

import org.dyw.simple.framework.orm.annotation.DSimpleSqlResultType;
import org.dyw.simple.framework.orm.annotation.DSimpleSqlType;
import org.dyw.simple.framework.orm.core.DaoBase;
import org.dyw.simple.framework.orm.core.extend.DSimpleDaoScan;
import org.dyw.simple.framework.orm.core.extend.DSimpleDaoBase;
import org.dyw.simple.framework.orm.po.DSimpleSqlInfo;

/**
 * @author 邓言文
 * @version 1.0.0
 * 这个类主要方便用户调用ORM功能
 * */
public class DSimpleDatabase {
    /**
     *  这里存着扫描类,构造方法执行后开始扫描，扫描完成后相关组件存储在扫描器对象内部.
     * */
    private static DSimpleDaoScan dSimpleDaoScan=null;
    /**
     * Dao
     * */
    private static DaoBase daoBase=null;
    /**
     * 扫描
     * */
    private static void scan(){
        if(dSimpleDaoScan==null){
            dSimpleDaoScan=new DSimpleDaoScan();
            if(dSimpleDaoScan.getDSimpleDatabaseConfigInfo()!=null){
                //打印配置
                System.out.println(
                    "DSimple->ORM->Scan->Database->Config->Diver:"
                            +dSimpleDaoScan.getDSimpleDatabaseConfigInfo().getDiver());
                System.out.println(
                    "DSimple->ORM->Scan->Database->Config->Url:"
                            +dSimpleDaoScan.getDSimpleDatabaseConfigInfo().getUrl());
                System.out.println(
                    "DSimple->ORM->Scan->Database->Config->Account:"
                            +dSimpleDaoScan.getDSimpleDatabaseConfigInfo().getAccount());
                System.out.println(
                    "DSimple->ORM->Scan->Database->Config->Password:"
                            +dSimpleDaoScan.getDSimpleDatabaseConfigInfo().getPassword());
                //初始化Dao
                daoBase=new DSimpleDaoBase(dSimpleDaoScan.getDSimpleDatabaseConfigInfo());
            }
        }

    }
    /**
     * @param name 是dao的名字
     * @return Object 是返回的结果
     * */
    public static Object using(String name,Object ...args){
        //扫描
        scan();
        if(dSimpleDaoScan.getDSimpleDatabaseConfigInfo()==null)return null;
        //查找SQL
        DSimpleSqlInfo dSimpleSqlInfo= (DSimpleSqlInfo) dSimpleDaoScan.getMapByName().get(name);
        if(dSimpleSqlInfo==null)return null;
        //执行该sql
        if(dSimpleSqlInfo.getSqlType()== DSimpleSqlType.Query){
            if(dSimpleSqlInfo.getResultType()== DSimpleSqlResultType.Object){
                Object o=daoBase.queryForValue(dSimpleSqlInfo.getSql(),args);
                return o;
            }
            else if(dSimpleSqlInfo.getResultType()== DSimpleSqlResultType.List){
                Object o=daoBase.queryForList(dSimpleSqlInfo.getSql(),args);
                return o;
            }
            else if(dSimpleSqlInfo.getResultType()== DSimpleSqlResultType.MAP){
                Object o=daoBase.queryForModel(dSimpleSqlInfo.getSql(),args);
                return o;
            }
        }
        else if(dSimpleSqlInfo.getSqlType()== DSimpleSqlType.Manipulation){
            daoBase.Manipulation(dSimpleSqlInfo.getSql(),args);
        }
        return null;
    }
}
