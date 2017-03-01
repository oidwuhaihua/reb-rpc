package com.dm.remoting.tcpip.format.xml;

import com.dm.remoting.tcpip.context.DmContext;
import com.dm.remoting.tcpip.format.BaseFormat;
import com.dm.remoting.tcpip.format.FormatConfigContainer;
import com.dm.remoting.tcpip.format.IFormat;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;

/**
 * @author whh
 * @date 2017/2/17 0017
 * @see
 * @since 1.1
 */
@SuppressWarnings("all")
public class FormatDefine extends BaseFormat implements IFormat{

    /**
     * SDOROOT常量
     */
    public final static String SDOROOT = "SDOROOT";
    //创建XML
    private Document document = DocumentHelper.createDocument();
    //节点容器
    private FormatConfigContainer childContainer = new FormatConfigContainer();
    //
    private String hedeName;

    /**
     * @param object
     * @param context
     */
    public void unFormat(Object object, DmContext context) {

    }
}
