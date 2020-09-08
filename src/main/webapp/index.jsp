<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>欢迎进入后台管理系统页面</h1>
<shiro:authenticated>
    <shiro:principal></shiro:principal>
    <a href="${pageContext.request.contextPath}/user/logout">退出1</a>
    <form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" value="退出2(配置登录拦截器)"/>
    </form>
    <a href="${pageContext.request.contextPath}/logout">退出2(配置登录拦截器)</a>
</shiro:authenticated>

<shiro:hasAnyRoles name="user,admin">
    <li><a href="">用户管理</a>
        <ul>
            <shiro:hasPermission name="user:add:*">
                <li><a href="">添加</a></li>
            </shiro:hasPermission>
            <shiro:hasPermission name="user:delete:*">
                <li><a href="">删除</a></li>
            </shiro:hasPermission>
            <shiro:hasPermission name="user:update:*">
                <li><a href="">修改</a></li>
            </shiro:hasPermission>
            <shiro:hasPermission name="user:find:*">
                <li><a href="">查询</a></li>
            </shiro:hasPermission>
        </ul>
    </li>
</shiro:hasAnyRoles>
<shiro:hasRole name="admin">
    <li><a href="">商品管理</a></li>
    <li><a href="">订单管理</a></li>
    <li><a href="">物流管理</a></li>
</shiro:hasRole>
</body>
</html>