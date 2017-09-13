## 视频列表接口

----

### 简要描述

- 视频列表接口


### 请求URL：

- ```http://127.0.0.1:8080/qwmapi/video```


### 请求方式

- POST 或 GET


### 请求头参数

|字段	| 类型	| 必选 |	说明|           
|-------|-------|------|--------|              
| QWM-CLIENT-TYPE | String | 否|客户端类型（1：安卓 2：iOS）|                


### 请求参数

无    

### 返回参数

|字段	| 类型	| 	说明|           
|-------|-------|------|            
| code | int    |  响应状态码 |      
| msg  | String |  描述信息  |  
| t  |  VideosRespBean| 视频信息列表类  |    

**VideosRespBean** 类说明

|字段	| 类型	| 	说明|           
|-------|-------|------|            
| videos | List    |  视频信息集合 |       

**VideoRespBean** 类说明

|字段	| 类型	| 	说明|           
|-------|-------|------|            
| id | long    |   视频的id|       
| length  | int |  视频时长 | 
| name  | String | 视频名字  | 
| image  | String |  视频的图片资源地址，需要拼接上基础地址 |
| url  | String | 视频的视频资源地址，需要拼接上基础地址  | 

### 状态码说明

|状态码 |	说明|           
|-------|-------|            
|  200     |    成功   |      
|  500     |    服务器有误   |    
|  600     |    至少应该请求一个真正的接口吧   |    
|  700     |    客户端类型不能为空   |    
|  701     |    客户端类型有误   |   

[状态码说明](statuscode.md)


### 返回示例

**json方式**
```json
{
    "code": 200,
    "msg": "成功",
    "t": {
        "videos": [
            {
                "id": 1,
                "image": "resources/images/minion_01.png",
                "length": 10,
                "name": "小黄人 第01部",
                "url": "resources/videos/minion_01.mp4"
            },
            {
                "id": 2,
                "image": "resources/images/minion_02.png",
                "length": 12,
                "name": "小黄人 第02部",
                "url": "resources/videos/minion_02.mp4"
            },
            {
                "id": 3,
                "image": "resources/images/minion_03.png",
                "length": 14,
                "name": "小黄人 第03部",
                "url": "resources/videos/minion_03.mp4"
            },
            {
                "id": 4,
                "image": "resources/images/minion_04.png",
                "length": 16,
                "name": "小黄人 第04部",
                "url": "resources/videos/minion_04.mp4"
            },
            {
                "id": 5,
                "image": "resources/images/minion_05.png",
                "length": 18,
                "name": "小黄人 第05部",
                "url": "resources/videos/minion_05.mp4"
            },
            {
                "id": 6,
                "image": "resources/images/minion_06.png",
                "length": 20,
                "name": "小黄人 第06部",
                "url": "resources/videos/minion_06.mp4"
            },
            {
                "id": 7,
                "image": "resources/images/minion_07.png",
                "length": 22,
                "name": "小黄人 第07部",
                "url": "resources/videos/minion_07.mp4"
            },
            {
                "id": 8,
                "image": "resources/images/minion_08.png",
                "length": 24,
                "name": "小黄人 第08部",
                "url": "resources/videos/minion_08.mp4"
            },
            {
                "id": 9,
                "image": "resources/images/minion_09.png",
                "length": 26,
                "name": "小黄人 第09部",
                "url": "resources/videos/minion_09.mp4"
            },
            {
                "id": 10,
                "image": "resources/images/minion_10.png",
                "length": 28,
                "name": "小黄人 第10部",
                "url": "resources/videos/minion_10.mp4"
            },
            {
                "id": 11,
                "image": "resources/images/minion_11.png",
                "length": 30,
                "name": "小黄人 第11部",
                "url": "resources/videos/minion_11.mp4"
            },
            {
                "id": 12,
                "image": "resources/images/minion_12.png",
                "length": 32,
                "name": "小黄人 第12部",
                "url": "resources/videos/minion_12.mp4"
            },
            {
                "id": 13,
                "image": "resources/images/minion_13.png",
                "length": 34,
                "name": "小黄人 第13部",
                "url": "resources/videos/minion_13.mp4"
            },
            {
                "id": 14,
                "image": "resources/images/minion_14.png",
                "length": 36,
                "name": "小黄人 第14部",
                "url": "resources/videos/minion_14.mp4"
            },
            {
                "id": 15,
                "image": "resources/images/minion_15.png",
                "length": 38,
                "name": "小黄人 第15部",
                "url": "resources/videos/minion_15.mp4"
            },
            {
                "id": 16,
                "image": "resources/images/minion_16.png",
                "length": 40,
                "name": "小黄人 第16部",
                "url": "resources/videos/minion_16.mp4"
            }
        ]
    }
}
```
**xml方式**
```
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<data>
    <code>200</code>
    <msg>成功</msg>
    <t >
        <videos>
            <video id="1" image="resources/images/minion_01.png" length="10" name="小黄人 第01部" url="resources/videos/minion_01.mp4"/>
            <video id="2" image="resources/images/minion_02.png" length="12" name="小黄人 第02部" url="resources/videos/minion_02.mp4"/>
            <video id="3" image="resources/images/minion_03.png" length="14" name="小黄人 第03部" url="resources/videos/minion_03.mp4"/>
            <video id="4" image="resources/images/minion_04.png" length="16" name="小黄人 第04部" url="resources/videos/minion_04.mp4"/>
            <video id="5" image="resources/images/minion_05.png" length="18" name="小黄人 第05部" url="resources/videos/minion_05.mp4"/>
            <video id="6" image="resources/images/minion_06.png" length="20" name="小黄人 第06部" url="resources/videos/minion_06.mp4"/>
            <video id="7" image="resources/images/minion_07.png" length="22" name="小黄人 第07部" url="resources/videos/minion_07.mp4"/>
            <video id="8" image="resources/images/minion_08.png" length="24" name="小黄人 第08部" url="resources/videos/minion_08.mp4"/>
            <video id="9" image="resources/images/minion_09.png" length="26" name="小黄人 第09部" url="resources/videos/minion_09.mp4"/>
            <video id="10" image="resources/images/minion_10.png" length="28" name="小黄人 第10部" url="resources/videos/minion_10.mp4"/>
            <video id="11" image="resources/images/minion_11.png" length="30" name="小黄人 第11部" url="resources/videos/minion_11.mp4"/>
            <video id="12" image="resources/images/minion_12.png" length="32" name="小黄人 第12部" url="resources/videos/minion_12.mp4"/>
            <video id="13" image="resources/images/minion_13.png" length="34" name="小黄人 第13部" url="resources/videos/minion_13.mp4"/>
            <video id="14" image="resources/images/minion_14.png" length="36" name="小黄人 第14部" url="resources/videos/minion_14.mp4"/>
            <video id="15" image="resources/images/minion_15.png" length="38" name="小黄人 第15部" url="resources/videos/minion_15.mp4"/>
            <video id="16" image="resources/images/minion_16.png" length="40" name="小黄人 第16部" url="resources/videos/minion_16.mp4"/>
        </videos>
    </t>
</data>
```
