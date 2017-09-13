package com.qwm.iostestapi.response;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.List;

/**
 * @author: wiming
 * @date: 2017-09-13 15:24:38  星期三
 * @decription: 天气
 */
public class WeatherRespBean implements IQwmResponse {
    @XmlAttribute
    public String ciry;
    @XmlAttribute
    public String status;

    public WeatherRespBean() {
    }

    public WeatherRespBean(String ciry, String status) {
        this.ciry = ciry;
        this.status = status;
    }
}
