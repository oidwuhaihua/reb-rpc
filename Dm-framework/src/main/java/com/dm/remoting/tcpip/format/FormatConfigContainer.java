package com.dm.remoting.tcpip.format;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 报文格式化配置容器
 *
 * @author whh
 * @date 2017/2/16 0016
 * @see
 * @since 1.1
 */
@SuppressWarnings("all")
public class FormatConfigContainer {

    public static Map<String,IFormat> formats = new HashMap<String, IFormat>();
    //格式化元素容器
    private Map<String,String> defines;
    //格式化配置文件地址容器
    private Map<String, String> configs;

    /**
     *  获取格式化实例
     * @param fmtName
     * @return
     */
    public static IFormat getFormat(String fmtName){
        return formats.get(fmtName);
    }


    public Map<String, String> getDefines() {
        return defines;
    }

    public void setDefines(Map<String, String> defines) {
        this.defines = defines;
    }

    public Map<String, String> getConfigs() {
        return configs;
    }

    public void setConfigs(Map<String, String> configs) {
        this.configs = configs;
    }
}
