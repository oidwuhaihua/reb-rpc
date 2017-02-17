package com.dm.remoting.tcpip.context;

import com.dm.remoting.tcpip.data.DmData;
import com.dm.remoting.tcpip.data.GroupData;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author whh
 * @date 2017/2/8 0008
 * @see
 * @since 1.1
 */

@SuppressWarnings("all")
public class DmContext implements Serializable ,Map<String,DmData>{

    //名称
    private String name ;
    //父节点名称
    private String parentContextName;
    //父节点
    private DmContext dmContext;
    //子节点列表
    private List<DmContext> childs;
    //上下文数据
    private GroupData dataElement;

    public  DmContext(){
        this.dataElement = new GroupData();
    }
    public DmContext(String name){
        this.name = name ;
        this.dataElement = new GroupData();
    }
    /**
     * 向上下文中添加单个数据
     * 如果上下文中已经存在相同名称的单个数据, 则覆盖原来的单个数据
     * @param name 单个数据的名称
     * @param value 单个数据的值
     * @throws InvalidArgumentException 如果数据对象的名称为空则返回参数错误异常
     */
    public void addFieldData(String name, Object value) {
        this.dataElement.addFieldData(name, value);
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
