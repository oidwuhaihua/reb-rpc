package com.dm.remoting.tcpip.processor;

import com.dm.remoting.tcpip.context.DmContext;
import com.dm.remoting.tcpip.data.GroupData;
import com.dm.remoting.tcpip.format.FormatConfigContainer;
import com.dm.remoting.tcpip.format.IFormat;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * @author whh
 * @date 2017/2/13 0013
 * @see DmContext
 * @see FormatConfigContainer
 * @since 1.1
 */
@SuppressWarnings("all")
public class CommProcessorImpl implements CommProcessor {
    Logger  logger = Logger.getLogger(CommProcessorImpl.class);
    public byte[] wrapMessagePackage(byte[] send) {
        System.out.println("message");
        return new byte[0];
    }

    public Object decode(DmContext context, byte[] message, String formatId) throws Exception {
        System.out.println("decode beign");
        //复制到数组中
        byte[] b = new byte[message.length-6];
        System.arraycopy(message, 6, b, 0, b.length);
        String result = new String(b);
        Element els ;
        try{
            //解析报文以及封装到各个对象之中
            context.addFieldData("receiveData", result);
            logger.info("receiveData :" + result);
            GroupData groupData = new GroupData();
            groupData.test();

            Document doc = DocumentHelper.parseText(result);
            els = doc.getRootElement();
            if(null == formatId){
                formatId = els.element("SYS_HEAD").elementText("SERVICE_CODE");
            }
        }catch (Exception e){
            throw new Exception();
        }
        //判断缓存是否有相应的配置
        IFormat format = FormatConfigContainer.getFormat("receive" + formatId);
        if(format == null) {
            throw new NullPointerException("找不到相应的formatId, 通信报文ID是 : " + formatId);
        }
        //format.unFormat(els,context);
        return null;
    }

    public Object encode(Object originalMessage, String formatId) {
        System.out.println("encode beign");
        return null;
    }

    public void runs() {
        System.out.println("test hello world");
    }
}
