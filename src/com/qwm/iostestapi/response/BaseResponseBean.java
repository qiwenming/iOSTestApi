package com.qwm.iostestapi.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author: wiming
 * @date: 2017-09-11 13:22:44  星期一
 * @decription:
 *  响应的基类
 */
@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class BaseResponseBean<T> implements Serializable {
    private int code;//响应的状态码（自己定义的）
    private String msg;//（描述信息）

    @XmlElement(name = "t")
    private T t;

    public void setStatusCode(ResponseStatusCode statusCode){
        this.msg = statusCode.getDesc();
        this.code = statusCode.getCode();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
