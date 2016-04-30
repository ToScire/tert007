<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 16.02.2016
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Cinema</title>
  </head>
  <body>

  <form action="Controller" method="POST">
    <input type="hidden" name="command" value="find_film_by_title"/>
    <input type="text" name="title" value="Film Title"/>
    <input type="submit" name="button" value="Find"/>
  </form>


  <form action="Controller" method="GET">
    <input type="hidden" name="command" value="find_film_by_id"/>
    <input type="number" name="film_id" value="1"/>
    <input type="submit" name="button" value="Find"/>
  </form>

  </body>
</html>
