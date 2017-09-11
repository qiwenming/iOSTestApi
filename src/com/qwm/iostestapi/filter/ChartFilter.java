package com.qwm.iostestapi.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: wiming
 * @date: 2017-09-11 13:49:21  星期一
 * @decription:
 *   字符过滤器，目的就是为了让所有的请求和响应都是 UTF-8
 */
public class ChartFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {

    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //1. 转换请求、响应对象
        HttpServletRequest request =(HttpServletRequest)req;
        HttpServletResponse response =(HttpServletResponse)resp;

        //2. 设置编码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=utf-8");


        chain.doFilter(request, response);
    }

    public void destroy() {
    }

}
