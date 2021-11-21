package org.dyw.simple.framework.orm.po;

public class DSimpleDatabaseConfigInfo {
    private String diver;
    private String url;
    private String account;
    private String password;

    public DSimpleDatabaseConfigInfo(String diver, String url, String account, String password) {
        this.diver = diver;
        this.url = url;
        this.account = account;
        this.password = password;
    }

    public String getDiver() {
        return diver;
    }

    public String getUrl() {
        return url;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }
}
