<%--
  Created by IntelliJ IDEA.
  User: Vadim
  Date: 01.05.2016
  Time: 1:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>${film.getTitle()}</title>
</head>
<body>
<form action="Controller" method="GET">
    <table>
        <tr>
            <td>Название:</td>
            <td><input type="text" value="${film.getTitle()}" name="title"></td>
        </tr>
        <tr>
            <td>Описание:</td>
            <td><input type="text" value="${film.getDescription()}" name="description"></td>
        </tr>
        <tr>
            <td>Жанр:</td>
            <td>
                <select name="genre">
                    <option
                            <c:if test="${film.getGenre() == 'DRAMA'}">
                                selected
                            </c:if>
                            value="DRAMA">DRAMA
                    </option>
                    <option
                            <c:if test="${film.getGenre() == 'COMEDY'}">
                                selected
                            </c:if>
                            value="COMEDY">COMEDY
                    </option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Дата выпуска:</td>
            <td><input type="date" value="${film.getDate()}" name="date"></td>
        </tr>
        <tr>
            <td>Режиссер:</td>
            <td><input type="text" value="${film.getDirector()}" name="director"></td>
        </tr>
        <tr>
            <td>Возрастные ограничения:</td>
            <td>
                <select name="age_limitation">
                    <option
                            <c:if test="${film.getAgeLimitation() == 'PG13'}">
                                selected
                            </c:if>
                            value="PG13">PG13
                    </option>
                    <option
                            <c:if test="${film.getAgeLimitation() == 'PG18'}">
                                selected
                            </c:if>
                            value="PG18">PG18
                    </option>
                </select>
            </td>
        </tr>
    </table>
    <input type="hidden" name="command" value="update_film"/>
    <input type="hidden" name="id" value="${film.getId()}">
    <input type="submit" name="button" value="Изменить фильм"/>
</form>
<a href="index.jsp">На главную</a>
</body>
</html>
