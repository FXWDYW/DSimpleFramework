package org.dyw.simple.framework.ioc.core.extend;

import org.dyw.simple.framework.ioc.annotation.DSimpleBean;
import org.dyw.simple.framework.ioc.core.Scan;
import org.dyw.simple.framework.ioc.po.DSimpleBeanInfo;

import java.util.HashMap;
import java.util.Map;

public class DSimpleBeanScan extends Scan {
    /**
     * 所有拥有该注解的类都加入Map
     * */
    @Override
    public void execute(Class<?> c) {
        DSimpleBean dSimpleBean=(DSimpleBean) c.getAnnotation(DSimpleBean.class);
        if(dSimpleBean!=null){
            //加入组件
            this.getMapByName().put(dSimpleBean.name(),
                    new DSimpleBeanInfo(c,
                            dSimpleBean.type(),
                            dSimpleBean.name()));
            System.out.println("DSimple->IOC->Scan->DSimpleBean:"+dSimpleBean.name());
        }
    }
}
