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
看总表

[状态码说明](statuscode.md)


### 返回示例
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


