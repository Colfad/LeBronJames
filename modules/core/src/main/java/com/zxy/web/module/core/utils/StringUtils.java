package com.zxy.web.module.core.utils;

/**
 * 字符串处理类，对字符串进行操作类
 *
 * @author James
 */
public class StringUtils {
    public static final String EMPTY = "";
    public static final String BLANK = " ";

    public static boolean isNullOrEmpty(final String str) {
        if (str == null || str.trim().equals("")) {
            return true;
        }

        return false;
    }
}
