package com.dm.remoting.tcpip.handler;

import com.dm.remoting.tcpip.processor.CommProcessor;
import org.jboss.netty.channel.ChannelHandler;

/**
 * @author whh
 * @date 2017/2/8 0008
 * @see
 * @since 1.1
 */
@SuppressWarnings("all")
public interface TCPIPHandler extends ChannelHandler {

    public CommProcessor getCommProcessor();

    public void setCommProcessor(CommProcessor commProcessor);
}
