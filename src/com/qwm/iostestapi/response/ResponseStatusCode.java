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
    LOGIN_ACCOUNT_NO_EXITS(20005, "账户不存在"),

    UPLOAD_FROM_UPLOAD(20010, "请以表单的方式上传数据"),
    UPLOAD_HAVE_NOT_FILE(20011, "请添加上传的文件"),
    UPLOAD_FAIL(20012, "文件上传失败"),
    UPLOAD_HAVE_NOT_EX(20013, "请添加文件扩展名"),

    WEATHER_NO_CITY(20020, "请添加查询城市"),
    WEATHER_NO_INFO(20021, "没有此城市的天气信息");

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
