package com.dm.remoting.tcpip.processor;

import com.dm.remoting.tcpip.context.DmContext;

/**
 *
 * 描述:通讯协议处理器接口<br/>
 * 根据不同的通讯协议对报文数据进行处理
 *
 * @author whh
 * @date 2017/2/8 0008
 * @see
 * @since 1.1
 */
@SuppressWarnings("all")
public interface CommProcessor {
    /**
     * 组装报文数据
     *
     * @param send 组装前的数据包
     * @return 组装后的报文数据
     */
    public  byte[] wrapMessagePackage(byte[] send);

    /**
     * 读取报文数据
     *
     * @param inputstream 报文数据流
     * @return 报文数据
     * @throws Exception 读取失败异常
     */

    public Object decode(DmContext context,byte[] message,String formatId) throws Exception;


    public Object encode(Object originalMessage,String formatId);

    public void runs();
}
