<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h2>注册页面</h2>
<form action="${pageContext.request.contextPath}/user/register" method="post">
    账号：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit" value="立即注册"><br>
</form>
</body>
</html>