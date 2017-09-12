package com.qwm.iostestapi.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: qiwenming(杞文明)
 * @date: 17/9/13 上午1:26
 * @className: AccountUtils
 * @description:
 * 账户相关的工具类 单例模式
 */
public class AccountUtils {

    /**
     * 账户Map集合
     */
    private Map<String,String> accountMap;

    private static AccountUtils sInstance;

    /**
     * 构造函数
     */
    private AccountUtils(){
        //创建map集合
        accountMap = new HashMap<>();
        //添加账户
        String pwd = Md5Utils.md5Encode( Md5Utils.md5Encode("123456") );
        accountMap.put("qiwenming",pwd);
        accountMap.put("小明",pwd);
    }

    public static AccountUtils getsInstance(){
        if(sInstance==null){
            sInstance = new AccountUtils();
        }
        return sInstance;
    }


    /**
     * 获取密码,如果密码为null,那么说明这个账号不存在
     * @param userName
     * @return
     */
    public String getPasswordByUserName(String userName){
        if(TextUtils.isEmpty(userName))
            return null;
        return accountMap.get(userName);
    }
}
