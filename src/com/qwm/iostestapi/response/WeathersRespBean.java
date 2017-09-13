package com.qwm.iostestapi.response;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * @author: wiming
 * @date: 2017-09-13 15:24:15  星期三
 * @decription:
 * 天气
 */
public class WeathersRespBean implements IQwmResponse {
    @XmlElement(name = "weather")
    @XmlElementWrapper(name = "weathers")
    public List<WeatherRespBean> weathers;
}
