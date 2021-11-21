package org.dyw.simple.framework.ioc.tool;

import org.dyw.simple.framework.ioc.annotation.DSimpleBeanType;
import org.dyw.simple.framework.ioc.core.Factory;
import org.dyw.simple.framework.ioc.core.Scan;
import org.dyw.simple.framework.ioc.core.extend.DSimpleBeanScan;
import org.dyw.simple.framework.ioc.core.impl.PrototypeFactory;
import org.dyw.simple.framework.ioc.core.impl.SingletonFactory;
import org.dyw.simple.framework.ioc.po.DSimpleBeanInfo;

/**
 * @author 邓言文
 * 这个工具类用来获取任意对象
 * */
public class DSimpleContext {
    /**
     *  这里存着扫描类,构造方法执行后开始扫描，扫描完成后相关组件存储在扫描器对象内部.
     * */
    private static Scan dSimpleBeanScan=null;
    /**
     * 扫描
     * */
    private static void scan(){
        if(dSimpleBeanScan==null)dSimpleBeanScan=new DSimpleBeanScan();
    }
    /**
     * @param name 是bean的名字
     * @return Object 是返回的对象
     * */
    public static Object getBean(String name){
        //扫描
        scan();
        DSimpleBeanInfo dSimpleBeanInfo= (DSimpleBeanInfo) dSimpleBeanScan.getMapByName().get(name);
        if(dSimpleBeanInfo!=null){
            if(dSimpleBeanInfo.getType()== DSimpleBeanType.Prototype){
                System.out.println("DSimple->IOC->Context->Get->Prototype"+dSimpleBeanInfo.getName());
                Factory factory=new PrototypeFactory();
                return factory.get(dSimpleBeanInfo.getC());
            }
            else if(dSimpleBeanInfo.getType()== DSimpleBeanType.Singleton){
                System.out.println("DSimple->IOC->Context->Get->Singleton:"+dSimpleBeanInfo.getName());
                Factory factory=new SingletonFactory();
                return factory.get(dSimpleBeanInfo.getC());
            }
        }
       return null;
    }
}
