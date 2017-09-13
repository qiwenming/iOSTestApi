package com.qwm.iostestapi.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

public class VideosRespBean {
    @XmlElement(name = "video")
    @XmlElementWrapper(name = "videos")
    public List<VideoRespBean> videos;
}
