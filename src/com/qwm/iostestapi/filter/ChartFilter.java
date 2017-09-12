package com.qwm.iostestapi.filter;

import com.google.gson.Gson;
import com.qwm.iostestapi.common.Contanst;
import com.qwm.iostestapi.response.BaseResponseBean;
import com.qwm.iostestapi.response.ResponseStatusCode;
import com.qwm.iostestapi.utils.TextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.qwm.iostestapi.response.ResponseStatusCode.*;

/**
 * @author: wiming
 * @date: 2017-09-11 13:49:21  星期一
 * @decription: 字符过滤器，目的就是为了让所有的请求和响应都是 UTF-8
 *   还有判断我们的地址是否符合要求,是否携带了 客户端类型（1：安卓 2：iOS）
 */
public class ChartFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException,
            IOException {

        //1. 转换请求、响应对象
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //2. 设置编码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=utf-8");

        //2. 判断一下你是不是直接请求我们的域名，后面什么都没，这样这个直接给你不给你资源，不要问我为什么，我就这么吊
        String uri = request.getRequestURI().replaceAll("/+","/");
        System.out.println(uri);
        if("".equals(uri) || "/".equals(uri)){
            BaseResponseBean responseBean = new BaseResponseBean();
            responseBean.setStatusCode(ResponseStatusCode.URI_NULL);
            String json = new Gson().toJson(responseBean);
            response.getWriter().write(json);
            return;
        }

        //3. 从请求头上获取到我们的客户端，客户端类型（1：安卓 2：iOS）
        String clientType = request.getHeader(Contanst.QWM_CLIENT_TYPE);
        ResponseStatusCode statusCode = OK;
        if (TextUtils.isEmpty(clientType)) {//没有传递客户端而类型，那么不让通过，告诉用户需要传递客户端类型
            statusCode = CLIENT_TYPE_NULL;
        } else if (!"1".equals(clientType) && !"2".equals(clientType)) {
            statusCode = CLIENT_TYPE_ERROR;;
        }

        if(statusCode!=OK){//返回
            BaseResponseBean responseBean = new BaseResponseBean();
            responseBean.setStatusCode(statusCode);
            String json = new Gson().toJson(responseBean);
            response.getWriter().write(json);
            return;
        }
        chain.doFilter(request, response);
    }

    public void destroy() {
    }

}
