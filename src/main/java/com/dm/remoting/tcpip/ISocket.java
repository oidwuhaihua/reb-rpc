package com.dm.remoting.tcpip;

import org.jboss.netty.bootstrap.Bootstrap;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipelineFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author whh
 * @date 2017/2/10 0010
 * @see
 * @since 1.1
 */
@SuppressWarnings("all")
public class ISocket {
    public boolean keepAlive;
    public boolean tcpNoDelay;
    public boolean reseAddress;
    public int soLinger;
    public int trafficClass;
    public long connectTimeoutMillis;
    private Bootstrap bootstrap;
    protected Map<String,Object> socketOptions = new HashMap<String, Object>();

    public ISocket(Bootstrap bootstrap){
        this.bootstrap = bootstrap;
    }
    public void setChannelFactory(ChannelFactory channelFactory){
        bootstrap.setFactory(channelFactory);
    }
    public void setPipelineFactory(ChannelPipelineFactory channlpipelineFactory){
        bootstrap.setPipelineFactory(channlpipelineFactory);
    }
    public void setOptions(Map<String,Object> socketOptions){
        bootstrap.setOptions(socketOptions);
    }
    /**
     * @return the bootstrap
     */
    public Bootstrap getBootstrap() {
        return bootstrap;
    }
}
