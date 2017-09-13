## 登录接口

----

### 简要描述

- 登录接口


### 请求URL：

- ```http://127.0.0.1:8080/qwmapi/login```


### 请求方式

- POST 或 GET


### 请求头参数

|字段	| 类型	| 必选 |	说明|           
|-------|-------|------|--------|              
| QWM-CLIENT-TYPE | String | 是|客户端类型（1：安卓 2：iOS）|                


### 请求参数

|字段	| 类型	| 必选 |	说明|           
|-------|-------|------|--------|       
|dataType|String| 否 |返回的数据格式。默认是json,如果需要xml格式，需要传递这个参数参数值为xml。可选值json、xml |           
|userName|String| 是 |用户名 |      
|password|String| 是 |密码(经过MD5加密一次的密文) |     

### 返回参数

|字段	| 类型	| 	说明|           
|-------|-------|------|            
| code | int    |  响应状态码 |      
| msg  | String |  描述信息  |  
| t  |  LoginResponseBean| 登录者的信息  |    

**LoginResponseBean** 类说明

|字段	| 类型	| 	说明|           
|-------|-------|------|            
| userName | String    |  用户名 |      
| clientType  | String |  客户端类型（1：安卓 2：iOS）  |  

### 状态码说明

|状态码 |	说明|           
|-------|-------|            
|  200     |    成功   |      
|  500     |    服务器有误   |    
|  600     |    至少应该请求一个真正的接口吧   |    
|  700     |    客户端类型不能为空   |    
|  701     |    客户端类型有误   |    
|  20001     |    账号不能为空   |    
|  20002     |    密码不能为空   |    
|  20003     |    账号有误   |    
|  20004     |    密码有误   |    

[状态码说明](statuscode.md)


### 返回示例

**json方式**
```json
{
    "code": 200,
    "msg": "登录成功",
    "t": {
        "userName": "qiwenming",
        "clientType": "1"
    }
}
```
**xml方式**
```
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<data>
    <code>200</code>
    <msg>登录成功</msg>
    <t >
        <userName>qiwenming</userName>
        <clientType>1</clientType>
    </t>
</data>
```
