<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h2>用户登录</h2>
<form action="${pageContext.request.contextPath}/user/login" method="post">
    用户名：<input type="text" name="username"/>
    <br/>
    密码：<input type="password" name="password"/>
    <br/>
    请输入验证码：<input type="text" name="code"/><img src="${pageContext.request.contextPath}/user/getImage">
    <br/>
    <input type="submit" value="登录" />
</form>
</body>
</html>