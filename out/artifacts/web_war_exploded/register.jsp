<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/8
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/register.do" method="post">
    姓名:<input type="text" name="username" /><br/>
    密码:<input type="password" name="pwd"/><br>
    email:<input type="email" name="email"/><br/>
    性别:<input type="radio" name="sex" value="男"/>男
    <input type="radio" name="sex" value="女"/>女<br/>
    注册地区：
    <select name="area">
        <option value="深圳">深圳</option>
        <option value="上海">上海</option>
        <option value="北京">北京</option>
    </select><br/>
    个人简介:
    <textarea cols="5" rows="10" name="desc"></textarea><br/>
    <input type="submit" value="注册"/>
    <input type="reset" value="取消"/>
</form>
</body>
</html>
