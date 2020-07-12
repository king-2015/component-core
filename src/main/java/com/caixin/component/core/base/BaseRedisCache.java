package com.caixin.component.core.base;

/**
 * @author zhuzhongji
 * 2018-06-28 13:06
 */
public abstract class BaseRedisCache extends BaseCache {

    /**
     * @return 缓存key
     */
    protected abstract String getKey();

}
