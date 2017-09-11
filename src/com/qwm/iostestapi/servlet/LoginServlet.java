package com.qwm.iostestapi.servlet;

import com.google.gson.Gson;
import com.qwm.iostestapi.response.BaseResponseBean;
import com.qwm.iostestapi.response.LoginResponseBean;
import com.qwm.iostestapi.response.ResponseStatusCode;
import com.qwm.iostestapi.utils.TextUtils;

import java.io.IOException;

import static com.qwm.iostestapi.response.ResponseStatusCode.*;

/**
 * @author: wiming
 * @date: 2017-09-11 12:53:46  星期一
 * @decription: 模拟登录接口
 */
public class LoginServlet extends javax.servlet.http.HttpServlet {

    /**
     * 用户名
     */
    private String mUserName = "qiwenming";
    /**
     * 密码 123456 的二次 MD5 值
     */
    private String mPassword = "14e1b600b1fd579f47433b88e8d85291";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //1.获取参数
        String username = request.getParameter("userName");
        String pwd = request.getParameter("password");

        //2. 创建响应的状态的枚举
        ResponseStatusCode requstStatus = SERIVE_ERROR;

        //3. 创建响应的实体类
        BaseResponseBean<LoginResponseBean> baseResponseBean = new BaseResponseBean<>();

        //4. 判断
        if( TextUtils.isEmpty(username) ){
            requstStatus = LOGIN_ACCOUNT_NULL;
        }else if( TextUtils.isEmpty(pwd) ){
            requstStatus = LOGIN_PASSWORD_NULL;
        }else if( !mUserName.equals(username) ){
            requstStatus = LOGIN_ACCOUNT_ERROR;
        }else if( !mPassword.equals(pwd) ){
            requstStatus = LOGIN_PASSWORD_ERROR;
        }else{
            requstStatus = OK;
            requstStatus.setDesc("登录成功");
            //创建登录信息的实体类
            LoginResponseBean loginResp = new LoginResponseBean();
            loginResp.userName = mUserName;
            baseResponseBean.t = loginResp;
        }

        // 5. 设置返回的状态码
        baseResponseBean.code = requstStatus.getCode();
        baseResponseBean.msg = requstStatus.getDesc();

        //6. 对象转为json
        String json = new Gson().toJson(baseResponseBean);

        System.out.println(json);

        //7. 返回Gson
        response.getWriter().write(json);
    }
}
