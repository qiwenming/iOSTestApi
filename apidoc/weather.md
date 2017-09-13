## 天气查询接口

----

### 简要描述

- 天气查询接口


### 请求URL：

- ```http://127.0.0.1:8080/qwmapi/weather```


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
|    20020    |     请添加查询城市   |    
|   20021     |    没有此城市的天气信息    |   

[状态码说明](statuscode.md)


### 返回示例

**json方式**
```json
{
    "code": 200,
    "msg": "成功",
    "t": {
        "weathers": [
            {
            "ciry": "yuannan",
            "status": "晴转多云"
            },
            {
            "ciry": "guangzhou",
            "status": "晴转多云"
            },
            {
            "ciry": "sichuan",
            "status": "晴转多云"
            }
        ]
    }
}
```
**xml方式**
```
<data>
    <code>200</code>
    <msg>成功</msg>
    <t>
        <weathers>
            <weather ciry="Yuannan" status="晴转多云"/>
            <weather ciry="Guangzhou" status="晴转多云"/>
            <weather ciry="Sichuan" status="晴转多云"/>
        </weathers>
    </t>
</data>
```
