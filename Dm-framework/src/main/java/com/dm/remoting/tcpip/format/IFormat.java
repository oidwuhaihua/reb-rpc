package com.dm.remoting.tcpip.format;

import com.dm.remoting.tcpip.context.DmContext;

/**
 * @author whh
 * @date 2017/2/16 0016
 * @see
 * @since 1.1
 */
@SuppressWarnings("all")
public interface IFormat {

    void unFormat(Object object, DmContext context);
}
