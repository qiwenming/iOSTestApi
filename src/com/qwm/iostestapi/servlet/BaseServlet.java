package com.qwm.iostestapi.servlet;

import com.google.gson.Gson;
import com.qwm.iostestapi.response.BaseResponseBean;
import com.qwm.iostestapi.utils.JaxbUtils;
import com.qwm.iostestapi.utils.TextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        //获取数据响应的数据格式类型  json 和xml
        String dataType = request.getParameter("dataType");

        String responseStr = "";

        //判断需要放回的数据类型,如果是 xml 那么放回xml,如果不是,那么放回json
        if(!TextUtils.isEmpty(dataType) && "xml".equals(dataType.toLowerCase())){
            //放回的是xml
            response.setContentType("text/xml;charset=utf-8");

            List<Class> clz = new ArrayList<Class>();
            clz.add(BaseResponseBean.class);
            //获取我们的泛型的实际类型
            if(baseResponseBean.t!=null){
                responseStr = JaxbUtils.convertToXml(baseResponseBean,BaseResponseBean.class,baseResponseBean.t.getClass());
            }else{
                responseStr = JaxbUtils.convertToXml(baseResponseBean,BaseResponseBean.class);
            }
            //去掉我们的 t中的属性
            // <t xsi:type="loginResponseBean" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
            // 替换为 <t>
            responseStr = responseStr.replaceAll("xsi:type=\"\\w+\" xmlns:xsi=\"\\S+\"","");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    public abstract BaseResponseBean<T> handlerRequest(HttpServletRequest request, HttpServletResponse response);
}
