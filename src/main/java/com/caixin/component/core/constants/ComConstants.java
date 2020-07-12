package com.caixin.component.core.constants;

/**
 * @author zhuzhongji
 * 2018-05-28 15:09
 */
public interface ComConstants {

    // 项目内常量使用的分隔符
    String SPLIT = "_";

    // Redis key前缀
    String REDIS_KEY = "redis_";

    // 防重复提交token KEY
    String REPEAT_TOKEN = "repeat_token";

    // 通用状态
    String[] STATUSES = {"禁用", "正常"};
    int STATUS_NO = 0; // 禁用
    int STATUS_OK = 1; // 正常

    // 是否
    String[] WHETHERS = {"否", "是"};
    int NO = 0;
    int YES = 1;

}
