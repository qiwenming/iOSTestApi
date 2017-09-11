package com.qwm.iostestapi.response;

import java.io.Serializable;

/**
 * @author: wiming
 * @date: 2017-09-11 13:22:44  星期一
 * @decription:
 *  响应的基类
 */
public class BaseResponseBean<T> implements Serializable {
    public int code;//响应的状态码（自己定义的）
    public String msg;//（描述信息）
    public T t;
}
