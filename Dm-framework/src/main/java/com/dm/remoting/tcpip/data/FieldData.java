package com.dm.remoting.tcpip.data;

/**
 * 描述:单个数据对象
 * 单个数据对象是最小的数据对象, 用来保存单个数据
 * 例如, 账号可以用单个数据对象来保存, 其XML描述如下:
 * <field id="accNo" value="11111111" />
 * @author whh
 * @date 2017/2/16 0016
 * @see DmData
 * @since 1.1
 */
@SuppressWarnings("all")
public class FieldData extends  DmData {
    //值
    private Object value;
    //默认值
    private Object defaultValue;
    //描述
    private String description;
    //类型
    private String dataType;

    /**
     *
     * @param name
     */
    public FieldData(String name){
        super(name);
    }
    public FieldData(String name ,Object value){
    super(name);
    setValue(value);
    }
    /**
     * 设置值
     * @param value 值
     */
    public void setValue(Object value) {
        this.value = value;
    }
}
