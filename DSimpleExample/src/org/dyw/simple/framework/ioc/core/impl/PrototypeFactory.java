package org.dyw.simple.framework.ioc.core.impl;

import org.dyw.simple.framework.ioc.core.Factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PrototypeFactory implements Factory {
    @Override
    public Object get(Class<?> c) {
        Object o=null;
        try {
            Constructor<?> constructors=c.getConstructor();
            o=constructors.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        finally {
            return o;
        }
    }
}
