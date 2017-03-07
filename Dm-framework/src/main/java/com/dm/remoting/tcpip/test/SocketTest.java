package com.dm.remoting.tcpip.test;

import com.dm.remoting.tcpip.ServerSocket;
import com.dm.remoting.tcpip.processor.CommProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author whh
 * @date 2017/2/13 0013
 * @see
 * @since 1.1
 */
@SuppressWarnings("all")
public class SocketTest {
    public static void main(String[] args) {
        ApplicationContext app = new FileSystemXmlApplicationContext("classpath:*tcpip-config.xml");
        CommProcessor cp = (CommProcessor) app.getBean("commProcessor");

        ServerSocket ss = new ServerSocket(1080,10000,2,10,cp);
      //  ClassPathResource res = new ClassPathResource("classpath:*tcpip-config.xml");
    }
}
