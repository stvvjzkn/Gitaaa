<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/8
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login.do" method="post">
    用户名：<input type="text" name="username"><br/>
    密码：<input type="password" name="password"><br/>
    <input type="checkbox" value="user" name="option">用户
    <input type="checkbox" value="admin" name="option">管理员<br/>
    <input type="submit" value="登陆">
    <a href="login.jsp"> <input type="button" value="重置"></a>
</form>
</body>
</html>
