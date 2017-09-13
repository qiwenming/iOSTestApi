package com.qwm.iostestapi.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @author: wiming
 * @date: 2017-09-11 13:23:29  星期一
 * @decription:
 *  登录的放回状态码
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class LoginResponseBean implements IQwmResponse {
    /**
     * 用户名
     */
    public String userName;
    /**
     * 客户端类型
     */
    public String clientType;

}
