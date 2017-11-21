## 上传文件接口

----

### 简要描述

- 上传文件接口


### 请求URL：

- ```http://127.0.0.1:8080/qwmapi/upload```


### 请求方式

- POST


### 请求头参数

|字段	| 类型	| 必选 |	说明|           
|-------|-------|------|--------|              
| QWM-CLIENT-TYPE | String | 否|客户端类型（1：安卓 2：iOS）|                


### 请求参数

|字段	| 类型	| 必选 |	说明|           
|-------|-------|------|--------|       
|dataType|String| 否 |返回的数据格式。默认是json,如果需要xml格式，需要传递这个参数参数值为xml。可选值json、xml |       
|userName|String| 否 |用户名 |               

除此之外就是你的文件数据
    

### 返回参数

|字段	| 类型	| 	说明|           
|-------|-------|------|            
| code | int    |  响应状态码 |      
| msg  | String |  描述信息  |  
 
### 状态码说明

|状态码 |	说明|           
|-------|-------|            
|  200     |    成功   |      
|  500     |    服务器有误   |    
|  600     |    至少应该请求一个真正的接口吧   |    
|  700     |    客户端类型不能为空   |    
|  701     |    客户端类型有误   |    
|  20010  |    请以表单的方式上传数据    |    
|  20011     |    请添加上传的文件    |    
|  20012      |    文件上传失败    |     

[状态码说明](statuscode.md)


### 返回示例

**json方式**
```json
{
    "code": 200,
    "msg": "上传成功",
    "t": {
        "userName": "wiming",
        "fileName": "/upload/a5fc2d74fbf153bded4eca87fbdba844.jpg"
    }
}
```
**xml方式**
```
<data>
    <code>200</code>
    <msg>上传成功</msg>
    <t>
        <userName>wiming</userName>
        <fileName>/upload/a5fc2d74fbf153bded4eca87fbdba844.jpg</fileName>
    </t>
</data>
```

### 图片完整地址

如果需要查看图片，请使用完整地址：基础地址+上面返回的地址 即可。

如：

基础地址是：http://127.0.0.1:8080/qwmapi

放回地址是：/upload/a5fc2d74fbf153bded4eca87fbdba844.jpg

下面的地址就是图片的完整地址：

http://127.0.0.1:8080/qwmapi/upload/a5fc2d74fbf153bded4eca87fbdba844.jpg
