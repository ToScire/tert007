<%--
  Created by IntelliJ IDEA.
  User: Vadim
  Date: 01.05.2016
  Time: 1:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <input type="text" name="genre" value="${film.getGenre()}">
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
            <td><input type="number" value="${film.getAgeLimitationId()}" name="age_limitation"></td>
        </tr>
    </table>
    <input type="hidden" name="command" value="update_film"/>
    <input type="hidden" name="id" value="${film.getId()}">
    <input type="submit" name="button" value="Изменить фильм"/>
</form>
<a href="index.jsp">На главную</a>
</body>
</html>
