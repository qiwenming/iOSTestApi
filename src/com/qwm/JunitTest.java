package com.qwm;

import com.qwm.iostestapi.response.*;
import com.qwm.iostestapi.servlet.LoginServlet;
import com.qwm.iostestapi.utils.FileDownUtils;
import com.qwm.iostestapi.utils.JaxbUtils;
import com.qwm.iostestapi.utils.VidesDataUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JunitTest {

    @Test
    public void textBeanToXml(){
        BaseResponseBean bean = new BaseResponseBean();
        bean.setStatusCode(ResponseStatusCode.OK);
        LoginResponseBean loginBean = new LoginResponseBean();
        loginBean.userName = "qiwenming";
        loginBean.clientType = "2";

        bean.t =  loginBean;
        String xml = JaxbUtils.convertToXml(bean,BaseResponseBean.class,LoginResponseBean.class);
        System.out.println(xml);
        xml = xml.replaceAll("xsi:type=\"\\w+\" xmlns:xsi=\"\\S+\"","");
        System.out.println(xml);
    }

    @Test
    public void textBeanToXml2(){
        BaseResponseBean bean = new BaseResponseBean();
        bean.setStatusCode(ResponseStatusCode.OK);

        VideosRespBean vs = new VideosRespBean();
        vs.videos = VidesDataUtils.getInstance().getVideos();

        bean.t = vs;
        String xml = JaxbUtils.convertToXml(bean,BaseResponseBean.class,bean.t.getClass());
        System.out.println(xml);
        xml = xml.replaceAll("xsi:type=\"\\w+\" xmlns:xsi=\"\\S+\"","");
        System.out.println(xml);
    }

}
