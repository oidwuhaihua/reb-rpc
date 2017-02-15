package com.dm.remoting.tcpip;

import com.dm.remoting.tcpip.constent.SocketConstent;
import com.dm.remoting.tcpip.pipeline.DefaultPipelineFactory;
import com.dm.remoting.tcpip.processor.CommProcessor;
import org.jboss.netty.bootstrap.Bootstrap;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.channel.group.DefaultChannelGroup;
import org.jboss.netty.channel.socket.oio.OioServerSocketChannelFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

/**
 * @author whh
 * @date 2017/2/8 0008
 * @see
 * @since 1.1
 */
@SuppressWarnings("all")
public class ServerSocket extends ISocket {

    Logger logger = LoggerFactory.getLogger(ServerSocket.class);

    public final static ChannelGroup allChannels = new DefaultChannelGroup();


    private final ServerBootstrap serverBootstrap;
    //默认等待容量大小
    public static int DEFAULT_BOSS_SIZE = 2;
    //默认线程大小
    public static int DEFAULT_WORK_SIZE = 10;
    private Channel serverChannel = null;
    //连接端口
    private int port;
    private final Map<String, Object> options;
    private final static String CHILD = "child.";

    /**
     *
     * @param port  监听端口
     * @param connectTimeout 连接超时时间配置
     * @param bossSize 主线程池大小配置
     * @param workSize 工作线程池大小配置
     * @param commProcessor 协处理器配置
     */
    public ServerSocket(int port,long connectTimeout,int bossSize,
                        int workSize, CommProcessor commProcessor){
        this(
                port,
                connectTimeout,
                new OioServerSocketChannelFactory(
                        Executors.newFixedThreadPool(bossSize),
                        Executors.newFixedThreadPool(workSize)),
                new DefaultPipelineFactory(SocketConstent.SERVERHANDLER, commProcessor),
                true, 10, false);
    }
    public ServerSocket(int port, long connectTimeout,
                        ChannelFactory channelFactory,
                        ChannelPipelineFactory channlpipelineFactory, boolean tcpNoDelay,
                        int soLinger, boolean keepAlive){
        super(new ServerBootstrap());

        options = new HashMap<String, Object>();
        this.port=port;
        setChannelFactory(channelFactory);
        setPipelineFactory(channlpipelineFactory);
        //指定连接超时时间
        options.put(CHILD+ SocketConstent.CONNECTTIMEOUTMILLIS,connectTimeout);
        options.put(CHILD+ SocketConstent.TCPNODELAY,true);
        options.put(CHILD+ SocketConstent.SOLINGER,-1);
        options.put(CHILD+ SocketConstent.KEEPALIVE,false);
        setOptions(options);
        serverBootstrap = (ServerBootstrap) getBootstrap();
        init();
    }

    public void init() {
        bind();
    }
    private void bind(){
     if(1 > this.port){
         throw new NullPointerException("port is not null!");
     }
        try{
            //绑定端口>接收请求>阻塞>处理
            serverChannel = serverBootstrap.bind(new InetSocketAddress(port));
            allChannels.add(serverChannel);
            logger.error("本地服务端口" + port + ",创建成功！");
        }catch (ChannelException e){
            logger.error("本地服务端口"+port+",创建失败！");
        }
    }

    protected void finalize()throws  Throwable{
        if(serverChannel!= null){
            try {
                serverChannel.unbind();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        super.finalize();
        }
    }




