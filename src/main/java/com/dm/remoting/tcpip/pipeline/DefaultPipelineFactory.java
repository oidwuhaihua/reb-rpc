package com.dm.remoting.tcpip.pipeline;

import com.dm.remoting.tcpip.handler.TCPIPHandler;
import com.dm.remoting.tcpip.processor.CommProcessor;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author whh
 * @date 2017/2/10 0010
 * @see
 * @since 1.1
 */
@SuppressWarnings("all")
public class DefaultPipelineFactory implements ChannelPipelineFactory {

    private static final Logger logger = LoggerFactory.getLogger(DefaultPipelineFactory.class);
    private CommProcessor commProcessor ;
    private String handlerName;
    public ChannelPipeline getPipeline() throws Exception {
        System.out.println("客户端连接,开始获取处理管道....."+this.handlerName);
        ChannelPipeline channelPipeline = Channels.pipeline();
        TCPIPHandler handler = (TCPIPHandler)Class.forName(this.handlerName).newInstance();

        handler.setCommProcessor(commProcessor);
        channelPipeline.addLast("TCPIPHandler", handler);
        System.out.println("客户端连接,加载处理管道成功.....");
        return channelPipeline;
    }
    public DefaultPipelineFactory(String handler,CommProcessor commProcessor){
        this.handlerName = handler;
        this.commProcessor = commProcessor;

    }
}
