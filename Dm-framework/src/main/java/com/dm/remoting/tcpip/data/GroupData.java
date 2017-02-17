package com.dm.remoting.tcpip.data;


import java.util.*;

/**
 * @author whh
 * @date 2017/2/16 0016
 * @see
 * @since 1.1
 */
@SuppressWarnings("all")
public class GroupData extends DmData implements Map<String,DmData> {

    //数据对象集合
    private Map<String,DmData> dataElements;
    //数据对象名称列表
    private List<String> dataNames;

    public GroupData(){
        this.dataElements = new HashMap<String, DmData>();
        this.dataNames = new ArrayList<String>();
    }

    /**
     *  添加对象数据
     * @param dmData
     */
    public void addDmData(DmData dataElement){
        this.dataElements.put(dataElement.getName(),dataElement);
        if(!dataNames.contains(dataElement.getName())){
            this.dataNames.add(dataElement.getName());
        }
    }
    public void test(){
        Map<String,DmData> test =   this.dataElements;
        System.out.println("获得值：" + test.get("receiveData"));
    }
    /**
     *
     * @param dataElement
     * @return 分组数据对象
     */
    public GroupData addGroupData(GroupData dataElement){
        addDmData(dataElement);
        return dataElement;
    }
    /**
     * 添加单个数据对象
     * @param name 单个数据对象的名称
     * @param value 单个数据对象的值
     * @throws InvalidArgumentException 如果名称为空, 则抛出参数错误异常
     */
    public void addFieldData(String name, Object value) {
        if (name == null) {
            throw new com.dm.remoting.tcpip.data.InvalidArgumentException("FieldData's name should not be null!");
        }

        FieldData field = new FieldData(name, value);
        addDmData(field);
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean containsKey(Object key) {
        return false;
    }

    public boolean containsValue(Object value) {
        return false;
    }

    public DmData get(Object key) {
        return null;
    }

    public DmData put(String key, DmData value) {
        return null;
    }

    public DmData remove(Object key) {
        return null;
    }

    public void putAll(Map<? extends String, ? extends DmData> m) {

    }

    public void clear() {

    }

    public Set<String> keySet() {
        return null;
    }

    public Collection<DmData> values() {
        return null;
    }

    public Set<Entry<String, DmData>> entrySet() {
        return null;
    }
}
