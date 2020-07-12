package com.caixin.component.core.util;

import com.caixin.component.core.base.BaseClass;

/**
 * @author zhuzhongji
 * 2018-08-20 14:10
 */
public class NumberUtils extends BaseClass {

    // 63进制 字符对照表
    private static final String FTSYSTEM = "MaCFyAoXglHvfksPLQZjtY_cpKur0123456789SEehNiBqJdVWTwRUGbmOzxInD";

    /**
     * 将 10进制 数字转化为 63进制字符
     * @param numOf10 数字
     * @return
     */
    public static String transformTo63(long numOf10) {
        StringBuilder lastChars = new StringBuilder();
        long quotients;
        while ((quotients = numOf10 / 63) > 0) {
            lastChars = lastChars.insert(0, FTSYSTEM.charAt((int)(numOf10 % 63)));
            numOf10 = quotients;
        }
        return lastChars.insert(0, FTSYSTEM.charAt((int)numOf10)).toString();
    }

    /**
     * 将 63 进制字符 转为 10进制数字
     * @param strOf63 字符
     * @return
     */
    public static Long transformTo10(String strOf63) {
        if (notBlank(strOf63)) {
            long num = 0;
            char[] chars = strOf63.toCharArray();
            for (int i = chars.length - 1, c = 0; i >= 0; i--, c++) {
                int index = FTSYSTEM.indexOf(String.valueOf(chars[i]));
                if (index == -1) {
                    System.err.println("transformTo10 failed > " + strOf63);
                    return null;
                }
                num += index * Math.pow(63, c);
            }
            return num;
        }
        return null;
    }

//    public static void main(String[] args) {
//        // just do it...
////        String numOf36 = "056085ce9a4d3690ce84";
////        long numOf10 = transformTo10(numOf36);
////        System.out.println(numOf36);
////        System.out.println(numOf10);
////        System.out.println(transformTo63(numOf10));
//
//        long time = System.currentTimeMillis();
//        String str = transformTo63(time);
//        System.out.println(time);
//        System.out.println(str);
//        System.out.println(transformTo10("adda3%4"));
//    }

}
