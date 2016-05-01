<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 30.04.2016
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Seances</title>
</head>
<body>
    <c:forEach var="seance" items="${seances}">
        <tr>
            <td>${seance.getFilm().getTitle()}</td>
            <td>${seance.getDate()}</td>
            <td>${seance.getTime()}</td>
        </tr>
    </c:forEach>
    <a href="index.jsp">На главную</a>
</body>
</html>
