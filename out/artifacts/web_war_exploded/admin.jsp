<%--
  Created by IntelliJ IDEA.
  User: 胡戈
  Date: 2020/9/11
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> this is admin window</h1>
<table border="1" style="border-collapse: collapse">
    <thead>
    <td>user_id</td>
    <td>user_psw</td>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="userinfo">
        <tr>
            <td><a href="update.do?id=${userinfo.user_id}">${userinfo.user_id}</a></td>
            <td>${userinfo.user_id}</td>
            <td>${userinfo.user_psw}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
