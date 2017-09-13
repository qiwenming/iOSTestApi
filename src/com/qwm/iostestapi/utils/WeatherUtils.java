package com.qwm.iostestapi.utils;

import com.qwm.iostestapi.response.WeatherRespBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wiming
 * @date: 2017-09-13 15:26:16  星期三
 * @decription:
 * 天气工具
 */
public class WeatherUtils {
    /**
     * 账户Map集合
     */
    private Map<String,WeatherRespBean> weatherMap;

    private static WeatherUtils sInstance;

    /**
     * 构造函数
     */
    private WeatherUtils(){
        //创建map集合
        weatherMap = new HashMap<>();
        //添加账户
        WeatherRespBean w1 = new WeatherRespBean("Beijing","晴转多云");
        WeatherRespBean w2 = new WeatherRespBean("Shenzhen","晴转多云");
        WeatherRespBean w3 = new WeatherRespBean("Shangahi","晴转多云");
        WeatherRespBean w4 = new WeatherRespBean("Yuannan","晴转多云");
        WeatherRespBean w5 = new WeatherRespBean("Guangzhou","晴转多云");
        WeatherRespBean w6 = new WeatherRespBean("Sichuan","晴转多云");
        weatherMap.put(w1.ciry,w1);
        weatherMap.put(w2.ciry,w2);
        weatherMap.put(w3.ciry,w3);
        weatherMap.put(w4.ciry,w4);
        weatherMap.put(w5.ciry,w5);
        weatherMap.put(w6.ciry,w6);
    }

    public static WeatherUtils getInstance(){
        if(sInstance==null){
            sInstance = new WeatherUtils();
        }
        return sInstance;
    }

    /**
     * 获取单个城市的天气
     * @param cityName
     * @return
     */
    public List<WeatherRespBean> getWeatherByCityName(String cityName){
        List<WeatherRespBean> weathers = new ArrayList<>();
        WeatherRespBean w = weatherMap.get(cityName);
        if(w!=null){
            weathers.add(w);
        }
        return weathers;
    }

    /**
     * 获取多个城市的天气
     * @param citys
     * @return
     */
    public List<WeatherRespBean> getWeathersByCityNames(List<String> citys){
        if(citys==null || citys.size()<=0)
            return null;
        List<WeatherRespBean> weathers = new ArrayList<>();
        for (String city:citys) {
            WeatherRespBean w = weatherMap.get(city);
            if(w!=null){
                weathers.add(w);
            }
        }
        return weathers;
    }

    /**
     * 获取多个城市的天气
     * @param citys
     * @return
     */
    public List<WeatherRespBean> getWeathersByCityNames(String[] citys){
        if(citys==null || citys.length<=0)
            return null;
        List<WeatherRespBean> weathers = new ArrayList<>();
        for (String city:citys) {
            WeatherRespBean w = weatherMap.get(city);
            if(w!=null){
                weathers.add(w);
            }
        }
        return weathers;
    }
}
