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

<div class="operation">
   <h3>Операции с фильмами</h3>

  <form action="Controller" method="GET">
    <input type="hidden" name="command" value="get_films_collection"/>
    <input type="submit" name="button" value="Вывести все фильмы"/>
  </form>

  <form action="Controller" method="POST">
    <input type="hidden" name="command" value="find_film_by_title"/>
    <input type="text" name="title" />
    <input type="submit" name="button" value="Найти фильмы по заголовку"/>
  </form>

  <form action="Controller" method="GET">
    <input type="hidden" name="command" value="find_film_by_id"/>
    <input type="number" name="film_id" value="1"/>
    <input type="submit" name="button" value="Найти фильм по id"/>
  </form>

  <form action="Controller" method="GET">
    <input type="hidden" name="command" value="find_film_by_date"/>
    <input type="date" name="date"/>
    <input type="submit" name="button" value="Найти фильм по dате"/>
  </form>

  <form action="Controller" method="GET">
    <input type="hidden" name="command" value="remove_film"/>
    <input type="number" name="film_id" value="1"/>
    <input type="submit" name="button" value="Удалить фильм"/>
  </form>

  <h4>Создание нового фильма</h4>
  <form action="Controller" method="POST">
    <input type="hidden" name="command" value="add_new_film">
    <table>
      <tr>
        <td>Введите название:</td>
        <td><input type="text" name="title"></td>
      </tr>
      <tr>
        <td>Введите описание фильма:</td>
        <td><textarea name="description" cols="20" rows="5">
        </textarea></td>
      </tr>
      <tr>
        <td>Введите id жанра фильма:</td>
        <td><input type="number" name="genre"></td>
      </tr>
      <tr>
        <td>Выберите возрастные ограничения:</td>
        <td>
        <input type="number" name="age_limitation">
        </td>
      </tr>
      <tr>
        <td>Введите режисера:</td>
        <td><input type="text" name="director"></td>
      </tr>
      <tr>
        <td>Введите дату создания:</td>
        <td><input type="date" name="date"></td>
      </tr>
      <tr>
        <td>
          <input type="submit" name="add">
        </td>
      </tr>
    </table>
  </form>
</div>

<div class="operation">
  <h3>Операции с пользователем</h3>

  <form action="Controller" method="GET">
    <input type="hidden" name="command" value="get_users_collection"/>
    <input type="submit" name="button" value="Вывести всех пользователей"/>
  </form>

  <form action="Controller" method="GET">
    <input type="hidden" name="command" value="get_user_by_id"/>
    <input type="number" name="user_id" value="1"/>
    <input type="submit" name="button" value="Найти пользователя"/>
  </form>

  <form action="Controller" method="POST">
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
