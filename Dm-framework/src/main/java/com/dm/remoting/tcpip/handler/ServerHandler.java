package com.dm.remoting.tcpip.handler;

import com.dm.remoting.tcpip.ServerSocket;
import com.dm.remoting.tcpip.context.DmContext;
import com.dm.remoting.tcpip.data.GroupData;
import com.dm.remoting.tcpip.processor.CommProcessor;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

/**
 * @author whh
 * @date 2017/2/8 0008
 * @see
 * @since 1.1
 */
@SuppressWarnings("all")
public class ServerHandler extends SimpleChannelUpstreamHandler implements TCPIPHandler {

    private final Logger logger = LoggerFactory.getLogger(ServerHandler.class);

    private CommProcessor commProcessor;

    public ServerHandler() {
    }
    public ServerHandler(CommProcessor commProcessor) {

        this.commProcessor = commProcessor;
    }

    public CommProcessor getCommProcessor() {
        return commProcessor;
    }

    public void setCommProcessor(CommProcessor commProcessor) {
        this.commProcessor=commProcessor;
}
    // 增加处理超时检查
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
            throws Exception {
        ChannelBuffer message = (ChannelBuffer) e.getMessage();
        byte[] segment =new  byte[message.capacity()];
        message.readBytes(segment);
        logger.info("服务端从：" + e.getRemoteAddress() + "接受：" + new String(segment));


        DmContext dc = new DmContext() ;
        commProcessor.decode(dc,segment,null);


        String results = "result hello world";
        byte[] resultByte = results.getBytes();
        ChannelBuffer messageBuff = ChannelBuffers.buffer(resultByte.length);
        logger.info("服务端向：" + e.getRemoteAddress() + "响应：" + new String(resultByte));
        messageBuff.writeBytes(resultByte);
        Channels.write(ctx, e.getFuture(), messageBuff);



    }
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e)
            throws Exception {
        logger.error("Unexpected exception from downstream." + e.getCause());
        e.getChannel().close();
    }
    public void channelBound(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        ServerSocket.allChannels.add(e.getChannel());
    }

    public void channelOpen(ChannelHandlerContext ctx, ChannelStateEvent e)
            throws Exception {
        ServerSocket.allChannels.add(e.getChannel());
    }

}
