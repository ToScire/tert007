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
        <caption>Films</caption>
        <tr>
            <th>id</th>
            <th>title</th>
            <th>director</th>
        </tr>

        <c:forEach var="film" items="${films}">
            <tr>
                <td>${film.getId()}</td>
                <td>${film.getTitle()}</td>
                <td>${film.getDirector()}</td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
