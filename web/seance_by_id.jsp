<%--
  Created by IntelliJ IDEA.
  User: Vadim
  Date: 07.05.2016
  Time: 1:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="Controller" method="GET">
    <table>
        <tr>
            <td>Название :</td>
            <td>
                <select name="film_id">
                    <c:forEach var="film" items="${films}">
                        <option
                            <c:if test="${film.getId().equals(seance.getFilm().getId())}">
                                selected
                            </c:if>
                                value="${film.getId()}">${film.getTitle()}
                        </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Зал:</td>
            <td>
                <select name="hall_id">
                    <c:forEach var="hall" items="${halls}">
                        <option
                                <c:if test="${hall.getId().equals(seance.getHall().getId())}">
                                    selected
                                </c:if>
                                value="${hall.getId()}">${hall.getId()}
                        </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Дата:</td>
            <td>
                <input type="date" value="${seance.getDate()}" name="date">
            </td>
        </tr>
        <tr>
            <td>
                Время:
            </td>
            <td>
                <input type="text" value= "${seance.getTime()}" name="time">
            </td>
        </tr>
        <tr>
            <td>
                Стоимость:
            </td>
            <td>
                <input type="number" value= "${seance.getPrice()}" name="price">
            </td>
        </tr>
    </table>
    <input type="hidden" name="command" value="update_seance"/>
    <input type="hidden" name="id" value="${seance.getId()}">
    <input type="submit" name="button" value="Изменить сеанс"/>
</form>
<a href="index.jsp">На главную</a>
</body>
</html>
