package com.caixin.component.core.util;

import java.io.Serializable;

/**
 * 结果集合工具
 *
 * @author zhuzhongji
 * 2018-05-24 9:38
 */
public class Result<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = 5571861040414743095L;

    private boolean success;
    private String info;
    private Integer code;
    private T data;

    public Result(T data) {
        this (true, null, null, data);
    }

    public Result(String info, Integer code) {
        this (false, info , code, null);
    }

    public Result(boolean success, String info, Integer code, T data) {
        this.success = success;
        this.info = info;
        this.code = code;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", info='" + info + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
