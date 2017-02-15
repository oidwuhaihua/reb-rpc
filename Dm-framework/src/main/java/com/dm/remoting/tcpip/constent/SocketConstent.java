package com.dm.remoting.tcpip.constent;

/**
 * @author whh
 * @date 2017/2/10 0010
 * @see SocketConstent1
 * @since 1.1
 */
@SuppressWarnings("all")
public class SocketConstent {

    public final static String REMOTEADDRESS = "remoteAddress";
    //启动Nagle算法，提高网络吞吐量，牺牲实时性
    public final static String TCPNODELAY = "tcpNoDelay";
   // 启用/禁用Nagle算法
    public final static String KEEPALIVE = "keepAlive";
    //地址是否可复用（UDP socket address绑定时用到）
    public final static String REUSEADDRESS = "reuseAddress";

    public final static String SOLINGER = "soLinger";
    //0<=tc<=255
    public final static String TRAFFICCLASS = "trafficClass";
    //启用/禁用具有指定逗留时间（以秒为单位）
    public final static String CONNECTTIMEOUTMILLIS = "connectTimeoutMillis";

    public final static String RECEIVEBUFFERSIZE = "receiveBufferSize";

    public final static String SENDBUFFERSIZE = "sendBufferSize";

    public final static String TCPIPHANDLER = "TCPIPHandler";

    public final static String CLIENTHANDLER ="com.fop.framework.tcpip.handler.ClientHandler";

    public final static String SERVERHANDLER ="com.dm.remoting.tcpip.handler.ServerHandler";

    public final static int HANDLER_FINISH = 1;

    public final static int READ_FINISH = 2;

    public final static int READ_TIMEOUT = 3;

    public final static int FORMAT_EXCEPTION = 4;

//  public final int  IPTOS_LOWCOST = 0x02;
//
//  public final int  IPTOS_RELIABILITY  = 0x04;
//
//  public final int  IPTOS_THROUGHPUT = 0x08;
//
//  public final int  IPTOS_LOWDELAY = 0x010;
}
