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
                <li role="presentation"><a href="index.jsp">Главная</a></li>
                <li role="presentation" class="active"><a href="Controller?command=get_today_seances">Сеансы</a></li>
                <li role="presentation"><a href="Controller?command=get_films_collection">Фильмы</a></li>
            </ul>
        </nav>
        <jsp:include page="included_user_profile.jsp"/>
    </div>


    <div class="jumbotron">

    <c:choose>
    <c:when test="${user == null}">
        <p>Ошибка, пользователь ${error_login} не найден</p>
    </c:when>
    <c:otherwise>
            <c:choose>
                <c:when test="${sessionScope.user.getLogin() == user.getLogin() && sessionScope.user.getPassword() == user.getPassword()}">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <input type="text" class="form-control" name="login" value="${user.getLogin()}">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="email" value="${user.getEmail()}">
                        </div>
                        <div class="form-group">
                            <input type="hidden" name="command" value="update_user">
                            <input type="hidden" name="password" value="${user.getPassword()}">
                            <input type="hidden" name="bonus_count" value="${user.getBonusCount()}">
                            <input type="hidden" name="user_type" value="${user.getUserType()}">
                            <input type="hidden" name="id" value="${user.getId()}">
                            <input type="submit" class="form-control" name="submit" value="Изменить данные">
                        </div>
                    </form>
                </c:when>
                <c:otherwise>
                    <p>Логин: ${user.getLogin()}
                    <p>Email: ${user.getEmail()}</p>
                </c:otherwise>
            </c:choose>
        </p>
        <p> Остаток на счету: ${user.getBonusCount()}</p>

        <table class="table">
            <caption>Билеты</caption>
            <tr>
                <td>Название Фильма</td>
                <td>Место</td>
                <td>Зал</td>
                <td>Дата</td>
                <td>Время сеанса</td>
            </tr>

            <c:forEach var="ticket" items="${tickets}">
                <tr>
                    <td>${ticket.getFilm().getTitle()}</td>
                    <td>${ticket.getPlace()}</td>
                    <td>${ticket.getHall().getId()}</td>
                    <td>${ticket.getDateByString()}</td>
                    <td>${ticket.getTimeByString()}</td>
                    <td>${ticket.getPrice()}</td>
                </tr>
            </c:forEach>

        </table>
    </c:otherwise>
</c:choose>
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
