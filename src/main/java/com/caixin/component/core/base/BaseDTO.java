package com.caixin.component.core.base;

/**
 *
 * DTO对象 (网络传输对象)
 * @author zhuzhongji
 * 2018-07-19 16:21
 */
public abstract class BaseDTO<T> extends BaseEntity {

    private static final long serialVersionUID = -7752857673813523888L;

    /**
     * 将DTO对象转换为实体对象
     * @return 实体对象
     */
    public abstract T convert();

}
