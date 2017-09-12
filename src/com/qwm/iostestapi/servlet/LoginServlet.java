package com.qwm.iostestapi.servlet;

import com.qwm.iostestapi.common.Contanst;
import com.qwm.iostestapi.response.BaseResponseBean;
import com.qwm.iostestapi.response.LoginResponseBean;
import com.qwm.iostestapi.response.ResponseStatusCode;
import com.qwm.iostestapi.utils.AccountUtils;
import com.qwm.iostestapi.utils.Md5Utils;
import com.qwm.iostestapi.utils.TextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.qwm.iostestapi.response.ResponseStatusCode.*;

/**
 * @author: wiming
 * @date: 2017-09-11 12:53:46  星期一
 * @decription: 模拟登录接口
 */
public class LoginServlet extends BaseServlet<LoginResponseBean> {

    @Override
    public BaseResponseBean<LoginResponseBean> handlerRequest(HttpServletRequest request, HttpServletResponse response) {
        //1.获取参数
        String username = request.getParameter("userName");
        String pwd = request.getParameter("password");
        String clientType = request.getHeader(Contanst.QWM_CLIENT_TYPE);
        //服务器保存的密码
        String password = AccountUtils.getsInstance().getPasswordByUserName(username);

        //2. 创建响应的状态的枚举
        ResponseStatusCode requstStatus = SERIVE_ERROR;

        //3. 创建响应的实体类
        BaseResponseBean<LoginResponseBean> baseResponseBean = new BaseResponseBean<>();

        //4. 判断
        if( TextUtils.isEmpty(username) ){
            requstStatus = LOGIN_ACCOUNT_NULL;
        }else if( TextUtils.isEmpty(pwd) ){
            requstStatus = LOGIN_PASSWORD_NULL;
        }else if( TextUtils.isEmpty(password) ){//账户不存在
            requstStatus = LOGIN_ACCOUNT_NO_EXITS;
        }else if( !password.equals(Md5Utils.md5Encode(pwd.toLowerCase())) ){//屏蔽大小写产生的影响
            requstStatus = LOGIN_PASSWORD_ERROR;
        }else{
            requstStatus = OK;
            requstStatus.setDesc("登录成功");
            //创建登录信息的实体类
            LoginResponseBean loginResp = new LoginResponseBean();
            loginResp.userName = username;
            loginResp.clientType = clientType;
            baseResponseBean.t = loginResp;
        }

        // 5. 设置返回的状态码
        baseResponseBean.code = requstStatus.getCode();
        baseResponseBean.msg = requstStatus.getDesc();

        return baseResponseBean;
    }

}
