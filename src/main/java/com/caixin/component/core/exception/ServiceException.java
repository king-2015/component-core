package com.caixin.component.core.exception;

/**
 *
 * 服务相关错误
 *
 * @author zhuzhongji
 * 2018-07-30 17:48
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 5230252580538988970L;

    public ServiceException(String message) {
        super(message);
    }

}
