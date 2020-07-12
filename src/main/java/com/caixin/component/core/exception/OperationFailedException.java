package com.caixin.component.core.exception;

/**
 * 操作失败异常
 * @author zhuzhongji
 * 2018-07-09 16:46
 */
public class OperationFailedException extends RuntimeException {

    private static final long serialVersionUID = 262639270878979004L;

    public OperationFailedException(String message) {
        super(message);
    }

}
