<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vadim
  Date: 07.05.2016
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление</title>
    <h4>Добавление сеанса</h4>
    <form action="Controller" method="GET">
        <table>
            <tr>
                <td>Выберите фильм</td>
                <td>
                    <select name="id_film">
                        <c:forEach var="film" items="${films}">
                            <option value="${film.getId()}">
                                    ${film.getTitle()}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Выберите Зал</td>
                <td>
                    <select name="id_hall">
                        <c:forEach var="hall" items="${halls}">
                            <option value="${hall.getId()}">
                                    ${hall.getId()}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Выбирете дату</td>
                <td><input type="date" name="date"></td>
            </tr>
            <tr>
                <td>Выбирите время</td>
                <td><input type="text" name="time"></td>
            </tr>
            <tr>
                <td>Выбирите стоимость</td>
                <td><input type="number" name="price"></td>
            </tr>
            <tr>
                <td>
                    <input type="hidden" name="command" value="add_new_seance">
                    <input type="submit" value="Добавить">
                </td>
            </tr>
        </table>
    </form>
</head>
<body>

</body>
</html>
