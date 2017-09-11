package com.qwm.iostestapi.utils;

import com.sun.istack.internal.Nullable;

/**
 * @author: wiming
 * @date: 2017-09-11 13:12:21  星期一
 * @decription:
 *   文本工具类
 */
public class TextUtils {

    /**
     * 判断一个字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(@Nullable CharSequence str) {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }
}
