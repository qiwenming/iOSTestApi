package com.qwm.iostestapi.servlet;

import com.qwm.iostestapi.response.BaseResponseBean;
import com.qwm.iostestapi.response.ResponseStatusCode;
import com.qwm.iostestapi.response.WeatherRespBean;
import com.qwm.iostestapi.response.WeathersRespBean;
import com.qwm.iostestapi.utils.WeatherUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import static com.qwm.iostestapi.response.ResponseStatusCode.OK;
import static com.qwm.iostestapi.response.ResponseStatusCode.WEATHER_NO_CITY;
import static com.qwm.iostestapi.response.ResponseStatusCode.WEATHER_NO_INFO;

/**
 * @author: wiming
 * @date: 2017-09-13 15:47:46  星期三
 * @decription:
 * 天气的接口
 */
public class WeatherServlet extends BaseServlet<WeathersRespBean>{

    @Override
    public BaseResponseBean<WeathersRespBean> handlerRequest(HttpServletRequest request, HttpServletResponse response) {
        BaseResponseBean<WeathersRespBean> baseResponseBean = new BaseResponseBean<>();
        String[] citys = request.getParameterValues("citys");
        if(citys==null){
            baseResponseBean.setStatusCode(WEATHER_NO_CITY);
            return baseResponseBean;
        }
        List<WeatherRespBean> list = WeatherUtils.getInstance().getWeathersByCityNames(citys);
        if(list==null || list.size()<=0){
            baseResponseBean.setStatusCode(WEATHER_NO_INFO);
            return baseResponseBean;
        }
        WeathersRespBean tBean = new WeathersRespBean();
        tBean.weathers = list;
        baseResponseBean.t = tBean;
        baseResponseBean.setStatusCode(OK);
        return baseResponseBean;
    }
}
