package com.caixin.component.core.exception;

/**
 * 资源找不到异常
 *
 */
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = -7766926765757400711L;

    /**
     * @param message 异常信息
     */
    public NotFoundException(String message) {
        super(message);
    }

}
