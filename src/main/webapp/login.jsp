<%--
  Created by IntelliJ IDEA.
  User: zb1209144
  Date: 2016/3/25
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Login</title>
</head>
<body>

<h1>Login</h1>
<form action="<c:url value="/login"/>" method="post">
    Username <input type="text" name="username">
    Password <input type="password" name="password">
    <input type="submit" value="Login">
</form>

</body>
</html>
