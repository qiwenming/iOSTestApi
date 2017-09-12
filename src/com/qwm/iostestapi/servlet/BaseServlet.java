package com.qwm.iostestapi.servlet;

import com.google.gson.Gson;
import com.qwm.iostestapi.response.BaseResponseBean;
import com.qwm.iostestapi.utils.TextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: qiwenming(杞文明)
 * @date: 17/9/13 上午1:34
 * @className: BaseServlet
 * @description:
 * Servlet的基类
 */
public abstract class BaseServlet<T> extends javax.servlet.http.HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BaseResponseBean<T> baseResponseBean = handlerRequest(request,response);

        if(baseResponseBean==null){
            throw new RuntimeException("处理的结果不能为空");
        }

        String dataType = request.getHeader("dataType");

        String responseStr = "";

        //判断需要放回的数据类型,如果是 xml 那么放回xml,如果不是,那么放回json
        if(!TextUtils.isEmpty(dataType) && "xml".equals(dataType.toLowerCase())){
            //放回的是xml
            response.setContentType("text/xml;charset=utf-8");

        }else{
            //返回json
            //对象转为json
            response.setContentType("text/json;charset=utf-8");
            responseStr = new Gson().toJson(baseResponseBean);
        }

        //打印
        System.out.println(responseStr);

        //返回数据
        response.getWriter().write(responseStr);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    public abstract BaseResponseBean<T> handlerRequest(HttpServletRequest req, HttpServletResponse resp);
}
