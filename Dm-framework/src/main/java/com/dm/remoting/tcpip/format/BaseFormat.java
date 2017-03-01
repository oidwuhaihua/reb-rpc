package com.dm.remoting.tcpip.format;

/**
 * @author whh
 * @date 2017/2/20 0020
 * @see
 * @since 1.1
 */
@SuppressWarnings("all")
public class BaseFormat {

    //数据名称
    private String dataName;
    //数据值
    private String dataValue;
    //域名称
    private String fieldName;
    //域值
    private String fieldValue;
    //描述信息
    private String desc;

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
