<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 29.03.2021
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spawn User</title>
</head>
<body>
<form action="controller">
    <input type="hidden" value="sign_up" name="command">
    Login:
    <input type="text" name="login">
    <br/>
    Email:
    <input type="email" name="email">
    <br/>
    Password:
    <input type="password" name="password">
    <br/>
    <input type="submit" value="Sign Up">
</form>
</body>
</html>
