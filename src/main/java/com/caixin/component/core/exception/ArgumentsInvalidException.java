package com.caixin.component.core.exception;

/**
 *
 * 参数错误异常
 * @author zhuzhongji
 * 2018-07-06 10:15
 */
public class ArgumentsInvalidException extends RuntimeException {

    private static final long serialVersionUID = -3172764931895634396L;

    public ArgumentsInvalidException(String message) {
        super(message);
    }

}
