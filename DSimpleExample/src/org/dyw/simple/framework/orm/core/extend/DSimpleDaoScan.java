package org.dyw.simple.framework.orm.core.extend;

import org.dyw.simple.framework.ioc.core.Scan;
import org.dyw.simple.framework.orm.annotation.DSimpleDao;
import org.dyw.simple.framework.orm.annotation.DSimpleDatabaseConfig;
import org.dyw.simple.framework.orm.annotation.DSimpleSql;
import org.dyw.simple.framework.orm.po.DSimpleDatabaseConfigInfo;
import org.dyw.simple.framework.orm.po.DSimpleSqlInfo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class DSimpleDaoScan extends Scan {
    private static DSimpleDatabaseConfigInfo dSimpleDatabaseConfigInfo=null;
    public static DSimpleDatabaseConfigInfo getDSimpleDatabaseConfigInfo() {
        return dSimpleDatabaseConfigInfo;
    }
    @Override
    public void execute(Class<?> c) {
        //扫描配置
        if(dSimpleDatabaseConfigInfo==null){
            DSimpleDatabaseConfig dSimpleDatabaseConfig=
                    (DSimpleDatabaseConfig) c.getAnnotation( DSimpleDatabaseConfig.class);
            if(dSimpleDatabaseConfig!=null){
                dSimpleDatabaseConfigInfo=new DSimpleDatabaseConfigInfo(
                        dSimpleDatabaseConfig.driver(),
                        dSimpleDatabaseConfig.url(),
                        dSimpleDatabaseConfig.account(),
                        dSimpleDatabaseConfig.password()
                );
            }
        }
        //扫描SQL
        DSimpleDao dSimpleDao=(DSimpleDao) c.getAnnotation(DSimpleDao.class);
        if(dSimpleDao==null){
            //扫描SQL
            DSimpleSql dSimpleSql=(DSimpleSql) c.getAnnotation(DSimpleSql.class);
            if(dSimpleSql==null)return;
            this.getMapByName().put(dSimpleSql.name(),
                    new DSimpleSqlInfo(
                            dSimpleSql.name(),
                            dSimpleSql.sql(),
                            dSimpleSql.sqlType(),
                            dSimpleSql.resultType()
                    ));
            return;
        }
        for(DSimpleSql dSimpleSql:dSimpleDao.value()){
            this.getMapByName().put(dSimpleSql.name(),
                    new DSimpleSqlInfo(
                            dSimpleSql.name(),
                            dSimpleSql.sql(),
                            dSimpleSql.sqlType(),
                            dSimpleSql.resultType()
                    )
            );
            System.out.println("DSimple->ORM->Scan->SQL:"+dSimpleSql.name());
        }

    }
}
