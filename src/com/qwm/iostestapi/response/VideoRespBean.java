package com.qwm.iostestapi.response;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author: wiming
 * @date: 2017-09-13 12:16:05  星期三
 * @decription: 视频集合的对象
 */
public class VideoRespBean implements IQwmResponse {
    @XmlAttribute
    public long id;
    @XmlAttribute
    public String image;
    @XmlAttribute
    public int length;
    @XmlAttribute
    public String name;
    @XmlAttribute
    public String url;
}
