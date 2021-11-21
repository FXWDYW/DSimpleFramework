package org.dyw.simple.framework.mvc.core.extend;

import org.dyw.simple.framework.ioc.core.Scan;
import org.dyw.simple.framework.mvc.annotation.DSimpleUrl;
import org.dyw.simple.framework.mvc.annotation.DSimpleUrls;
import org.dyw.simple.framework.mvc.po.DSimpleUrlInfo;
import org.dyw.simple.framework.orm.annotation.DSimpleDao;
import org.dyw.simple.framework.orm.annotation.DSimpleDatabaseConfig;
import org.dyw.simple.framework.orm.annotation.DSimpleSql;
import org.dyw.simple.framework.orm.po.DSimpleDatabaseConfigInfo;
import org.dyw.simple.framework.orm.po.DSimpleSqlInfo;

public class DSimpleUrlsScan extends Scan {
    @Override
    public void execute(Class<?> c) {
        //扫描URL
        DSimpleUrls dSimpleUrls=(DSimpleUrls) c.getAnnotation(DSimpleUrls.class);
        if(dSimpleUrls==null){
            //扫描URL
            DSimpleUrl dSimpleUrl=(DSimpleUrl) c.getAnnotation(DSimpleUrl.class);
            if(dSimpleUrl==null)return;
            this.getMapByName().put(dSimpleUrl.name(),
                    new DSimpleUrlInfo(
                            dSimpleUrl.name(),
                            dSimpleUrl.path()
                    ));
            System.out.println("DSimple->MVC->Scan->URL:"+dSimpleUrl.name());
            return;
        }
        for(DSimpleUrl dSimpleUrl:dSimpleUrls.value()){
            this.getMapByName().put(dSimpleUrl.name(),
                    new DSimpleUrlInfo(
                            dSimpleUrl.name(),
                            dSimpleUrl.path()
                    ));
            System.out.println("DSimple->MVC->Scan->URL:"+dSimpleUrl.name());
        }

    }
    //针对用户的加强
    public String getPath(String name){
        DSimpleUrlInfo dSimpleUrlInfo = (DSimpleUrlInfo) this.getMapByName().get(name);
        if(dSimpleUrlInfo==null)return null;
        return dSimpleUrlInfo.getPath();
    }

}
