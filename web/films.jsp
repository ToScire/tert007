<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 22.02.2016
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Films</title>
</head>
<body>
<table>
    <caption>Users</caption>
    <tr>
        <td>Название</td>
        <td>Описание</td>
        <td>Жанр</td>
        <td>Дата выпуска</td>
        <td>Режиссер</td>
        <td>Возрастные ограничения</td>
    </tr>

    <c:forEach var="film" items="${films}">
        <tr>
            <td>${film.getTitle()}</td>
            <td>${film.getDescription()}</td>
            <td>${film.getGenre()}</td>
            <td>${film.getDate()}</td>
            <td>${film.getDirector()}</td>
            <td>${film.getAgeLimitationId()}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>