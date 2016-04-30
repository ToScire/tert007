<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vadim
  Date: 30.04.2016
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Пользователь по ID</title>
</head>
<body>
<form action="Controller" method="GET">
    <table>
    <tr>
        <td>Логин:</td>
        <td><input type="text" value="${user.getLogin()}" name="login"></td>
    </tr>
    <tr>
        <td>Пароль:</td>
        <td><input type="text" value="${user.getPassword()}" name="password"></td>
    </tr>
    <tr>
        <td>Email:</td>
        <td><input type="text" value="${user.getEmail()}" name="email"></td>
    </tr>
    <tr>
        <td>Количество бонусов:</td>
        <td><input type="number" value="${user.getBonusCount()}" name="bonus_count"></td>
    </tr>
    </table>
    <input type="hidden" name="command" value="update_user"/>
    <input type="hidden" name="id" value="${user.getId()}">
    <input type="submit" name="button" value="Изменить пользователя"/>
    </form>
</body>
</html>
