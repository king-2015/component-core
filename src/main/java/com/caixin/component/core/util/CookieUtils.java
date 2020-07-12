package com.caixin.component.core.util;

import com.caixin.component.core.base.BaseUtils;

/**
 * @author zhuzhongji
 * 2018-06-14 11:44
 */
public class CookieUtils extends BaseUtils {

    private CookieUtils() { throw new UnsupportedOperationException(); }

    @SuppressWarnings("unchecked")
    public static <T> T getValue(String cookies, String name) throws ClassCastException {
        if (notBlank(cookies) && notBlank(name)) {
            cookies = cookies.replace(" ", "");
            String[] cookieArr = cookies.split(";");
            if (cookieArr.length > 0) {
                for (String cookie : cookieArr) {
                    if (cookie.startsWith(name + "=")) {
                        return (T) (cookie.substring(name.length() + 1, cookie.length()));
                    }
                }
            }
        }
        return null;
    }

//    // 测试
//    public static void main(String[] args) {
//        // just do it...
//        String cookies = "UM_distinctid=160b5921dd92ef-0fb5f395baf83-5d4e211f-1fa400-160b5921ddb356; " +
//                "BDTUJIAID=d2f3147b5bd594cabf317979c79d3ec9; " +
//                "CNZZDATA1258398875=1810361711-1514870313-https%253A%252F%252Fwww.baidu.com%252F%7C1528943413; " +
//                "CNZZDATA1260439972=1511797376-1514871613-https%253A%252F%252Fwww.baidu.com%252F%7C1528943364; " +
//                "CNZZDATA1259665137=933197276-1514872827-https%253A%252F%252Fwww.baidu.com%252F%7C1528945229; " +
//                "CNZZDATA1259697407=1561471647-1528870262-https%253A%252F%252Fwww.baidu.com%252F%7C1528946604; " +
//                "Hm_lvt_7a3d919664d39f5547bd796a73d9b0a8=1528787994,1528874053,1528948306; " +
//                "Hm_lpvt_7a3d919664d39f5547bd796a73d9b0a8=1528948306";
//        System.out.println((String) getValue(cookies, "UM_distinctid"));
//        System.out.println((String) getValue(cookies, "BDTUJIAID"));
//        System.out.println((String) getValue(cookies, "CNZZDATA1258398875"));
//        System.out.println((String) getValue(cookies, "Hm_lvt_7a3d919664d39f5547bd796a73d9b0a8"));
//    }

}
