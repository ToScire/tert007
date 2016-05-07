<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vadim
  Date: 07.05.2016
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Билеты</title>
</head>
<body>
<table>
    <caption>Tickets</caption>
    <tr>
        <td>Название Фильма</td>
        <td>Место</td>
        <td>Зал</td>
        <td>Дата</td>
        <td>Время сеанса</td>
    </tr>


    <tr>
        <td>${ticket.getFilm().getTitle()}</td>
        <td>${ticket.getPlace()}</td>
        <td>${ticket.getHall().getId()}</td>
        <td>${seance.getDate()}</td>
        <td>${seance.getTime()}</td>
    </tr>
</table>

<a href="index.jsp">На главную</a>

</body>
</html>
