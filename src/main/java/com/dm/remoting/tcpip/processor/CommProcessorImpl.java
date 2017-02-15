package com.dm.remoting.tcpip.processor;

import com.dm.remoting.tcpip.context.DmContext;

/**
 * @author whh
 * @date 2017/2/13 0013
 * @see
 * @since 1.1
 */
@SuppressWarnings("all")
public class CommProcessorImpl implements CommProcessor {
    public byte[] wrapMessagePackage(byte[] send) {
        System.out.println("message");
        return new byte[0];
    }

    public Object decode(DmContext context, byte[] message, String formatId) throws Exception {
        System.out.println("decode beign");
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
