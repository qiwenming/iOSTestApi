package com.qwm;

import com.qwm.iostestapi.response.*;
import com.qwm.iostestapi.servlet.LoginServlet;
import com.qwm.iostestapi.utils.JaxbUtils;
import org.junit.Test;

public class JunitTest {

    @Test
    public void textBeanToXml(){
        BaseResponseBean bean = new BaseResponseBean();
        bean.setStatusCode(ResponseStatusCode.OK);
        LoginResponseBean loginBean = new LoginResponseBean();
        loginBean.setUserName("qiwenming");
        loginBean.setClientType("2");

        bean.setT( loginBean);
        String xml = JaxbUtils.convertToXml(bean,BaseResponseBean.class,LoginResponseBean.class);
        System.out.println(xml);
    }


}
