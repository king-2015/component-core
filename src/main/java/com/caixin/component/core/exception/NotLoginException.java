package com.caixin.component.core.exception;

/**
 *
 * 未登入异常
 *
 * @author zhuzhongji
 * 2018-07-31 16:50
 */
public class NotLoginException extends RuntimeException {

    private static final long serialVersionUID = -5838452983860826479L;

    public NotLoginException(String message) {
        super(message);
    }

}
