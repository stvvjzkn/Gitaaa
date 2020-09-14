<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/8
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" style="border-collapse: collapse">
    <thead>
    <td>编号</td>
    <td>姓名</td>
    <td>email</td>
    <td>性别</td>
    <td>城市</td>
    <td>描述</td>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="userinfo">
    <tr>
        <td><a href="update.do?id=${userinfo.user_id}">${userinfo.user_id}</a></td>
        <td>${userinfo.username}</td>
        <td>${userinfo.email}</td>
        <td>${userinfo.sex}</td>
        <td>${userinfo.area}</td>
        <td>${userinfo.info}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
