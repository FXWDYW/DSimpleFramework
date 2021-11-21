package org.dyw.simple.framework.ioc.core;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public abstract class Scan  {
    private Map<String, Object> MapByName=new HashMap<>();
    public Map<String, Object> getMapByName() {
        return MapByName;
    }
    /**
     * 存储类加载路径
     * */
    private String classPath=null;
    public String getClassPath(){
        return this.classPath;
    }
    /**
     * 初始化的时候扫描所有类，并将相关的类处理.
     * */
    public Scan(){
        File file = new File(this.getClass().getResource("/").getPath());
        this.classPath=file.getAbsolutePath();
        System.out.println("classes->root:"+this.classPath);
        //扫描
        file=new File(this.classPath);
        scanClass(file);

    }
    private void scanClass(File file){
        if(file.isFile())return;
        File[] fileCollection=file.listFiles();
        if(fileCollection==null)return;
        for(int i=0;i<fileCollection.length;++i) {
            //此处写写处理办法
            if(getFileType(fileCollection[i]).equals("class")){
                try {
                    String path=fileCollection[i].getPath();
                    path=path.replace(this.classPath+"\\","");
                    path=path.replace(".class","");
                    path=path.replace("\\",".");
                    Class<?> c=Class.forName(path);
                    execute(c);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            scanClass(fileCollection[i]);
        }
        return;
    }
    //获取文件类型
    private String getFileType(File file) {
        String fileName=file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
    /**
     * @param c 是扫描到的类 具体实现由子类决定.
     * */
    abstract public void execute(Class<?> c);
}
