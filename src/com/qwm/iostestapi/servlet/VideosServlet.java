package com.qwm.iostestapi.servlet;

import com.qwm.iostestapi.response.BaseResponseBean;
import com.qwm.iostestapi.response.ResponseStatusCode;
import com.qwm.iostestapi.response.VideosRespBean;
import com.qwm.iostestapi.utils.VidesDataUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: wiming
 * @date: 2017-09-13 13:04:02  星期三
 * @decription:
 * 获取视频列表的接口
 */
public class VideosServlet extends BaseServlet<VideosRespBean> {
    @Override
    public BaseResponseBean<VideosRespBean> handlerRequest(HttpServletRequest req, HttpServletResponse resp) {
        BaseResponseBean<VideosRespBean> baseResponseBean = new BaseResponseBean<>();
        //返回的状态码为OK
        baseResponseBean.setStatusCode(ResponseStatusCode.OK);
        //创建视频集合的bean
        VideosRespBean videos = new VideosRespBean();
        //获取视频集合
        videos.videos = VidesDataUtils.getInstance().getVideos();
        baseResponseBean.t = videos;
        return baseResponseBean;
    }
}