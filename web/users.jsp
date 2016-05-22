<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vadim
  Date: 30.04.2016
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Пользователи</title>
</head>
<body>
<table>
    <caption>Все пользователи</caption>
    <tr>
    <td>id</td>
    <td>login</td>
    <td>Email</td>
    <td>Количество бонусов</td>
    <td>Тип пользователя</td>

    </tr>
    <c:forEach var="user" items="${users}">
    <tr>
        <td>${user.getId()}</td>
        <td>${user.getLogin()}</td>
        <td>${user.getEmail()}</td>
        <td>${user.getBonusCount()}</td>
        <td>${user.getUserType()}</td>
    </tr>
    </c:forEach>

</table>
<a href="index_test.jsp">На главную</a>
</body>
</html>
