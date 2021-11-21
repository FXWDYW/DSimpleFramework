package org.dyw.simple.framework.ioc.po;

import org.dyw.simple.framework.ioc.annotation.DSimpleBeanType;

/**
 * 存储类的信息
 * */
public class DSimpleBeanInfo {
    private Class<?> c;
    private DSimpleBeanType type;
    private String name;
    public DSimpleBeanInfo(Class<?> c, DSimpleBeanType type, String name) {
        this.c = c;
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public DSimpleBeanType getType() {
        return type;
    }

    public Class<?> getC() {
        return c;
    }
}