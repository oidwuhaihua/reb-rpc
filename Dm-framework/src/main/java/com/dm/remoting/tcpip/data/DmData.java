package com.dm.remoting.tcpip.data;

/**
 * @author whh
 * @date 2017/2/16 0016
 * @see
 * @since 1.1
 */
@SuppressWarnings("all")
public class DmData {
    //名称（唯一标识）
    private String name ;
    //别名
    private String destName;
    //增加标识 true=可增 false=不可增加
    private boolean append = false;

    public DmData(){}

    public DmData(String name){
        this.name= name ;
    }
    /**
     * 克隆对象
     * @return
     */
    public DmData clone(){
        DmData element = new DmData(this.name);
        element.setAppend(this.append);
        return element;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestName() {
        return destName;
    }

    public void setDestName(String destName) {
        this.destName = destName;
    }

    public boolean isAppend() {
        return append;
    }

    public void setAppend(boolean append) {
        this.append = append;
    }
}
