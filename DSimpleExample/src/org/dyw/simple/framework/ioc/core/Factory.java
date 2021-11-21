package org.dyw.simple.framework.ioc.core;
/**
 * @author 邓言文
 * 这是工厂的接口 实现以后主要用作生产对象
 * */
public interface Factory {
    public Object get(Class<?> c);
}
