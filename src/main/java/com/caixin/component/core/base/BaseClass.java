package com.caixin.component.core.base;

import com.caixin.component.core.constants.ComConstants;

import java.util.HashSet;
import java.util.Set;

/**
 * 项目基类 提供一些公用的方法和常量
 * Created by zhuzhongji on 2017/5/4.
 */
public abstract class BaseClass {

    /**
     * 是
     */
    public static final int YES = ComConstants.YES;
    /**
     * 否
     */
    public static final int NO = ComConstants.NO;

    /**
     * 状态 no
     */
    public static final int STATUS_NO = ComConstants.STATUS_NO;
    /**
     * 状态 ok
     */
    public static final int STATUS_OK = ComConstants.STATUS_OK;

    /**
     * 输
     */
    protected static final int LOSE = -1;
    /**
     * 平局
     */
    protected static final int TIE = 0;
    /**
     * 赢
     */
    protected static final int WIN = 1;

    /**
     * 判断字符 不是空的 （空客也算空字符串）
     * @param str 字符串
     * @return boolean
     */
    protected static boolean notBlank(String str) {
        return !isBlank(str);
    }

    /**
     * 判断字符 是空的 (空格也算空字符串)
     * @param str 字符串
     * @return boolean
     */
    protected static boolean isBlank(String str) {
        return str == null || "".equals(str.trim());
    }

    /**
     * 判断字符 是纯数字
     * @param str 字符串
     * @return boolean
     */
    protected static boolean isNumeric(String str) {
        if (isBlank(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符 不是纯数字
     * @param str 字符串
     * @return boolean
     */
    protected static boolean notNumeric(String str) {
        return !isNumeric(str);
    }

    /**
     * 字符串去重
     * @param str 原字符串
     * @return 新字符串
     */
    protected static String distinct(String str) {
        if (str == null || str.length() <= 1)
            return str;
        Set<String> old = new HashSet<>();
        StringBuilder newStr = new StringBuilder();
        for (int i = 0, l = str.length(); i < l; i++) {
            String t = String.valueOf(str.charAt(i));
            if (!old.contains(t)) {
                old.add(t);
                newStr.append(t);
            }
        }
        return newStr.toString();
    }

    /**
     * 查看值是否在范围中
     * 默认忽略空格
     * @param range 范围
     * @param x 值
     * @return res
     */
    protected static boolean inRange(String range, String x) {
        return indexOfRange(range, x) >= 0;
    }

    /**
     * 确认值在范围中的位置
     * @param range 范围
     * @param x 值
     * @return 位置
     */
    protected static int indexOfRange(String range, String x) {
        if (range != null && x != null) {
            String[] ranges = range.split(",");
            x = x.trim();
            for (int i = 0; i < ranges.length; i++) {
                if (ranges[i].trim().equals(x)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 检测元素是否在数组内
     *
     * @param arr 数组
     * @param i   元素
     * @return 是否
     * @author yjy
     * Created on 2017年12月12日 下午12:14:14
     */
    protected static boolean inArray(Integer[] arr, Integer i) {
        return indexOfArray(arr, i) >= 0;
    }

    /**
     * 获取元素所在位置
     * @param arr 范围
     * @param i 值
     * @return 位置
     */
    protected static int indexOfArray(Integer[] arr, Integer i) {
        if (i == null) return -1;
        for (int j = 0; j < arr.length; j++) {
            if (i.equals(arr[j])) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 判断参数是否是 0|1
     *
     * @param yesOrNo 参数
     * @return 是否
     * @author yjy
     * Created on 2017年12月14日 上午10:11:10
     */
    protected static boolean isYesOrNo(Integer yesOrNo) {
        return yesOrNo != null && (yesOrNo == 1 || yesOrNo == 0);
    }

}
