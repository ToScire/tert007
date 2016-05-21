<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 07.05.2016
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<h4>Регистрация</h4>
<form action="Controller" method="GET">
    <input type="hidden" name="command" value="registration_user"/>
    <table>
        <tr>
            <td> Введите логин: </td>
            <td><input type="text" required name="login"></td>
        </tr>
        <tr>
            <td> Введите пароль: </td>
            <td><input type="password" required name="password"></td>
        </tr>
        <tr>
            <td> Введите email: </td>
            <td><input type="email" required name="email"></td>
        </tr>
        <tr>
            <td><input type="submit" name="button" value="Зарегестрироваться"/></td>
        </tr>
        <c:out value="${errorMessage}"/>
    </table>
</form>
</body>
</html>
