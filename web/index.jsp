<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 16.02.2016
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>

<html>
  <head>
    <title>Cinema</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" >
  </head>
  <body>

  <div class="operation">

    <c:choose>
      <c:when test="${sessionScope.user.getLogin() == null || sessionScope.user.getUserType() == null}">
        <div class="operation">
          <h4>Логирование</h4>
          <form name="loginForm" action="Controller" method="POST">
            <input type="hidden" name="command" value="login_user" />
            Login:<br/>
            <input type="text" required name="login" value=""/>
            <br/>Password:<br/>
            <input type="password" required name="password" value=""/>
            <br/>
            <input type="submit" value="Log in"/>
          </form>
        </div>
        <c:out value="${errorMessage}"/>
        <br/>
        <a href="/registration.jsp">Регистрация</a>
      </c:when>
      <c:otherwise>
        <a href="Controller?command=find_user_by_login&login=${sessionScope.user.getLogin()}">${sessionScope.user.getLogin()}</a>
        <br>
        ${sessionScope.user.getUserType()}
        <br>
        <a href="Controller?command=logout_user">Выйти</a>
      </c:otherwise>
    </c:choose>
  </div>

  <a href="Controller?command=get_today_seances">Посмотреть сеансы на сегодня</a>
  <br>
  <a href="Controller?command=get_films_collection">Посмотреть фильмы</a>
  <br>

  </body>
</html>
