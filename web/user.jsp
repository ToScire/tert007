<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 10.05.2016
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>

        <c:choose>
            <c:when test="${user == null}">
                Ошибка
            </c:when>
            <c:otherwise>
                ${user.getLogin()}
            </c:otherwise>
        </c:choose>

    </title>
</head>

<body>

<c:choose>
    <c:when test="${user == null}">
        <p>Ошибка, пользователь ${error_login} не найден</p>
    </c:when>
    <c:otherwise>
        ${user.getLogin()}
        <br>
        ${user.getBonusCount()}
        <br>

        <table>
            <caption>Билеты</caption>
            <tr>
                <td>Название Фильма</td>
                <td>Место</td>
                <td>Зал</td>
                <td>Дата</td>
                <td>Время сеанса</td>
            </tr>

            <c:forEach var="ticket" items="${tickets}">
                <tr>
                    <td>${ticket.getFilm().getTitle()}</td>
                    <td>${ticket.getPlace()}</td>
                    <td>${ticket.getHall().getId()}</td>
                    <td>${ticket.getDate()}</td>
                    <td>${ticket.getTime()}</td>
                    <td>${ticket.getPrice()}</td>
                </tr>
            </c:forEach>

        </table>
    </c:otherwise>
</c:choose>



<a href="index.jsp">На главную</a>
</body>
</html>
