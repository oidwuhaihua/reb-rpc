package com.dm.remoting.tcpip.data;

/**
 * @author whh
 * @date 2017/2/16 0016
 * @see
 * @since 1.1
 */
@SuppressWarnings("all")
public class InvalidArgumentException extends RuntimeException {

    /**
     * 构造函数
     *
     * @param message 错误信息
     */
    public InvalidArgumentException(String message) {
        super(message);
    }
}
