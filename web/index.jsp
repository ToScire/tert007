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
    <link href="css/style.css" rel="stylesheet" type="text/css" >
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

  <form action="Controller" method="GET">
    <input type="hidden" name="command" value="get_users_collection"/>
    <input type="submit" name="button" value="Найти всех пользователей"/>
  </form>
<div class="user_operation">

  <h3>Операции с пользователем</h3>
  <form action="Controller" method="GET">
    <input type="hidden" name="command" value="get_user_by_id"/>
    <input type="number" name="user_id" value="1"/>
    <input type="submit" name="button" value="Найти пользователя"/>
  </form>

  <form action="Controller" method="GET">
    <input type="hidden" name="command" value="remove_user"/>
    <input type="number" name="user_id" value="1"/>
    <input type="submit" name="button" value="Удалить пользователя"/>
  </form>
  <h4>Регистрация</h4>
  <form action="Controller" method="GET">
    <input type="hidden" name="command" value="reg_user"/>
    <table>
      <tr>
        <td> Введите логин: </td>
        <td><input type="text" name="login"></td>
      </tr>
      <tr>
        <td> Введите пароль: </td>
        <td><input type="password" name="password"></td>
      </tr>
      <tr>
        <td> Введите email: </td>
        <td><input type="text" name="email"></td>
      </tr>
      <tr>
        <td><input type="submit" name="button" value="Зарегестрироваться"/></td>
      </tr>
    </table>
  </form>
</div>

  </body>
</html>
