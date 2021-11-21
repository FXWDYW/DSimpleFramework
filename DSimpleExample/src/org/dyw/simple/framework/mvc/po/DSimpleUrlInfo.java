package org.dyw.simple.framework.mvc.po;

public class DSimpleUrlInfo {
    private String name;
    private String path;

    public DSimpleUrlInfo(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }
}
