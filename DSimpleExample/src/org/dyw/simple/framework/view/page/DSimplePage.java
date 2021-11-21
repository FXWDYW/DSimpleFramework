package org.dyw.simple.framework.view.page;
/**
 * @auther dyw
 * @vesion 1.1.0
 * 通过这个类统一管理系统页面.在外界写好页面，复制粘贴进来.
 * 警告:不准及任何静态资源.
 * */
//用来存储系统页的
public  class  DSimplePage {
    public static String error="<!DOCTYPE html>\n" +
            "<html>\n" +
            "\t<head>\n" +
            "\t\t<meta charset=\"utf-8\" />\n" +
            "\t\t<title></title>\n" +
            "\t</head>\n" +
            "\t<body>\n" +
            "\t\t<div style=\"text-align: center;\" ><h1>DSimple框架才不会出错呢,肯定是你的问题😠</h1></div>\n" +
            "\t</body>\n" +
            "</html>\n";
    public static String error404="<!DOCTYPE html>\n" +
            "<html>\n" +
            "\t<head>\n" +
            "\t\t<meta charset=\"utf-8\" />\n" +
            "\t\t<title></title>\n" +
            "\t</head>\n" +
            "\t<body>\n" +
            "\t\t<div style=\"text-align: center;\" ><h1>404:你也配?\uD83D\uDE05</h1></div>\n" +
            "\t</body>\n" +
            "</html>\n";
}
