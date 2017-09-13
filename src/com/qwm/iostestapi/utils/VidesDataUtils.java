package com.qwm.iostestapi.utils;

import com.qwm.iostestapi.response.VideoRespBean;

import java.util.*;

/**
 * @author: wiming
 * @date: 2017-09-13 12:31:17  星期三
 * @decription:
 * 视频类的工具类
 */
public class VidesDataUtils {
    /**
     * 视频数据集合
     */
    private List<VideoRespBean> videos;

    private static VidesDataUtils sInstance;

    /**
     * 构造函数
     */
    private VidesDataUtils(){
        if(videos==null){//创建
            videos = new ArrayList<>();
            String numStr = "";
            int indexAddOne = 1;
            for (int i = 0; i < 16; i++) {
                indexAddOne = i+1;
                numStr = indexAddOne+"";
                if( indexAddOne <10 ){
                    numStr = "0"+indexAddOne;
                }
                //创建对象
                VideoRespBean bean = new VideoRespBean();
                bean.id = indexAddOne;
                bean.name = "小黄人 第"+numStr+"部";
                bean.length = 10 + i*2;
                bean.image = "resources/images/minion_"+numStr+".png";
                bean.url = "resources/videos/minion_"+numStr+".mp4";
                videos.add(bean);
            }
        }
    }

    public static VidesDataUtils getInstance(){
        if(sInstance==null){
            sInstance = new VidesDataUtils();
        }
        return sInstance;
    }

    public List<VideoRespBean> getVideos(){
        return videos;
    }
}
