<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>

<html>

<!-- Mirrored from getbootstrap.com/examples/jumbotron-narrow/ by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 21 May 2016 20:34:47 GMT -->
<!-- Added by HTTrack -->
<meta http-equiv="content-type" content="text/html;charset=utf-8"/><!-- /Added by HTTrack -->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://getbootstrap.com/favicon.ico">

    <title>Narrow Jumbotron Template for Bootstrap</title>

    <link href="css/jumbotron-narrow.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">

    <script src="js/jquery-2.2.4.js" type="text/javascript"></script>
    <script src="js/moment-with-locales.js" type="text/javascript"></script>
    <script src="js/bootstrap.js" type="text/javascript"></script>
    <script src="js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>

</head>

<body>

<div class="container">
    <div class="header clearfix">
        <nav>
            <ul class="nav nav-pills pull-right">
                <li role="presentation" class="active"><a href="index.jsp">Главная</a></li>
                <li role="presentation"><a href="Controller?command=get_today_seances">Сеансы</a></li>
                <li role="presentation"><a href="Controller?command=get_films_collection">Фильмы</a></li>
            </ul>
        </nav>
        <c:choose>
            <c:when test="${sessionScope.user.getLogin() == null || sessionScope.user.getUserType() == null}">
                <p class="sign_in">Выполните <a href="signin.jsp">Вход</a></p>
                <c:out value="${errorMessage}"/>
                <br/>
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

    <div class="jumbotron">

        <form class="form-horizontal" role="form">
            <div class="form-group">
                <label for="select_name" class="col-sm-2 control-label">Фильм</label>
                <div class="col-sm-10">
                    <select name="film_id" id="select_name" class="form-control">
                        <c:forEach var="film" items="${films}">
                            <option
                                    <c:if test="${film.getId().equals(seance.getFilm().getId())}">
                                        selected
                                    </c:if>
                                    value="${film.getId()}">${film.getTitle()}
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="select_hall" class="col-sm-2 control-label">Зал</label>
                <div class="col-sm-10">
                    <select name="hall_id" class="form-control" id="select_hall">
                        <c:forEach var="hall" items="${halls}">
                            <option
                                    <c:if test="${hall.getId().equals(seance.getHall().getId())}">
                                        selected
                                    </c:if>
                                    value="${hall.getId()}">${hall.getId()}
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group" action="Controller" method="GET">
                <label for="select_date" class="col-sm-2 control-label">Дата</label>
                <div class="col-sm-10">
                    <div class='input-group date' id='datetimepicker1'>
                        <input type='text' class="form-control" name="date" id="select_date"/>
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar">
                                </span>
                            </span>
                    </div>
                </div>
                <script type="text/javascript">
                    $(function () {
                        $('#datetimepicker1').datetimepicker(
                                {pickTime: false, language: 'ru'}
                        );
                    });
                </script>
            </div>

            <div class="form-group" action="Controller" method="GET">
                <label for="select_time" class="col-sm-2 control-label">Время</label>
                <div class="col-sm-10">
                    <div class='input-group date' id='datetimepicker2'>
                        <input type='text' class="form-control" name="time" id="select_time"/>
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-time">
                                </span>
                            </span>
                    </div>
                </div>
                <script type="text/javascript">
                    $(function () {
                        $('#datetimepicker2').datetimepicker({
                                    language: 'ru',
                                    format: 'HH:mm',
                                    pickDate: false
                                }
                        );
                    });
                </script>
            </div>

            <div class="form-group">
                <label for="select_number" class="col-sm-2 control-label">Стоимость билета</label>
                <div class="col-sm-10">
                    <input type="number" id="select_number" class="form-control" value="${seance.getPrice()}"
                           name="price">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default" name="button">Изменить</button>
                </div>
            </div>



            <input type="hidden" name="command" value="update_seance"/>
            <input type="hidden" name="id" value="${seance.getId()}">
        </form>

    </div>

    <footer class="footer">
        <p>&copy; 2016 Cinemator, Inc.</p>
    </footer>

</div> <!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="assets/js/ie10-viewport-bug-workaround.js"></script>
</body>

<!-- Mirrored from getbootstrap.com/examples/jumbotron-narrow/ by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 21 May 2016 20:34:48 GMT -->
</html>
