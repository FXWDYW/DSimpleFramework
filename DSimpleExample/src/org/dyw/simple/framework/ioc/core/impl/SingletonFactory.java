package org.dyw.simple.framework.ioc.core.impl;

import org.dyw.simple.framework.ioc.core.Factory;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class SingletonFactory implements Factory {
    private static Map<Class<?>,Object> objectMap=new HashMap<>();
    @Override
    public Object get(Class<?> c) {
        Object o=objectMap.get(c);
        try {
        if(o==null){
            Constructor<?> constructors= null;
            constructors = c.getConstructor();
            o=constructors.newInstance();
            objectMap.put(c,o);
        }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        finally {
            return o;
        }
    }
}
