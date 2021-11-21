package org.dyw.simple.framework.mvc.core;
/**
 * 短期数据保存的接口
 * */
public interface DSimpleMemory {
    public void save(String name);
    public Object read(String name);
    public boolean empty();
    public void clear(String name);
    public void clear();
}
