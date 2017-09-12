package com.qwm.iostestapi.response;

public enum  ResponseStatusCode {

    OK(200, "成功"),

    SERIVE_ERROR(500, "服务器有误"),

    URI_NULL(600, "至少应该请求一个真正的接口吧"),

    CLIENT_TYPE_NULL(700, "客户端类型不能为空"),
    CLIENT_TYPE_ERROR(701, "客户端类型有误"),

    LOGIN_ACCOUNT_NULL(20001, "账号不能为空"),
    LOGIN_PASSWORD_NULL(20002, "密码不能为空"),
    LOGIN_ACCOUNT_ERROR(20003, "账号有误"),
    LOGIN_PASSWORD_ERROR(20004, "密码有误"),
    LOGIN_ACCOUNT_NO_EXITS(20005, "账户不存在");

    private int code;
    private String desc;
    ResponseStatusCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
