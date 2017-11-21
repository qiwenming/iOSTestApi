<%--
  Created by IntelliJ IDEA.
  User: qiwenming
  Date: 2017/9/11
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>

    <script>
        function loginFormsubmit() {
            var form = document.getElementById("loginForm");
            if ("get" == document.getElementById("loginMethod").value) {
                form.setAttribute("method", "get");
            }
            form.setAttribute("QWM-CLIENT-TYPE", "2");
            form.submit();
        }

        function videoFormsubmit() {
            var form = document.getElementById("videoForm");
            if ("get" == document.getElementById("videoMethod").value) {
                form.setAttribute("method", "get");
            }
            form.submit();
        }
    </script>
</head>
<body>

<font size="6">详细信息可以查看 <a href="https://github.com/qiwenming/iOSTestApi"></a></font>

<br>-------------登录-------------<br>
<form action="login" method="post" id="loginForm" QWM-CLIENT-TYPE="2">
    用户名<input name="userName"><br>
    密码<input name="password"><br>
    请求方式<select id="loginMethod">
    <option value=get>GET</option>
    <option value="post">POST</option>
</select><br>
    返回数据格式<select name="dataType">
    <option value="JSON">JSON</option>
    <option value="XML">XML</option>
</select><br>
    <input type="button" value="登录" onclick="loginFormsubmit();">
</form>


<br>
<p>-------------获得视频信息-------------<br>
<form action="video" method="post" id="videoForm">
    请求方式<select id="videoMethod">
    <option value=get>GET</option>
    <option value="post">POST</option>
</select><br>
    返回数据格式<select name="dataType">
    <option value="JSON">JSON</option>
    <option value="XML">XML</option>
</select><br>
    <input type="button" value="获得视频信息" onclick="videoFormsubmit();">
</form>


<br>
<p>-------------文件上传-------------<br>
<form action="upload" method="post" enctype="multipart/form-data">
    上传用户：<input type="text" name="userName"><br/>
    <input type="file" name="file"><br>
    返回数据格式<select name="dataType">
    <option value="JSON">JSON</option>
    <option value="XML">XML</option>
</select><br>
    <input type="submit" value="上传">
</form>

<p>-------------文件上传2-------------<br>
    直接流方式上传，不使用表单
<%--<form action="upload2" method="post" enctype="multipart/form-data">
    <input type="file" name="file"><br>
    返回数据格式<select name="dataType">
    <option value="JSON">JSON</option>
    <option value="XML">XML</option>
</select><br>
    <input type="submit" value="上传">
</form>--%>

<br>
<p>-------------多值参数-------------<br>
<form action="weather" method="get">
    <input type="checkbox" name="citys" value="Beijing"> Beijing <br>
    <input type="checkbox" name="citys" value="Shenzhen"> Guangzhou <br>
    <input type="checkbox" name="citys" value="Shangahi"> Shanghai <br>
    <input type="checkbox" name="citys" value="Yuannan"> Shanghai <br>
    <input type="checkbox" name="citys" value="Guangzhou"> Shanghai <br>
    <input type="checkbox" name="citys" value="Sichuan"> Shanghai <br>
    返回数据格式<select name="dataType">
    <option value="JSON">JSON</option>
    <option value="XML">XML</option>
</select><br>
    <input type="submit" value="查看天气预报">
</form>

</body>
</html>
