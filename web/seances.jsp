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


        <table class="table">

            <form name="find_seances" action="Controller" method="get">

                <div class="container">
                    <div class="col-sm-6">
                        <div class="form-group">
                            <div class='input-group date' id='datetimepicker1'>
                                <input type='text' class="form-control" name="start_date"/>
                <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar">
                    </span>
                </span>
                            </div>
                        </div>
                    </div>

                    <script type="text/javascript">
                        $(function () {
                            $('#datetimepicker1').datetimepicker(
                                    {pickTime: false, language: 'ru'}
                            );
                        });
                    </script>

                    <div class="container">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <div class='input-group date' id='datetimepicker2'>
                                    <input type='text' class="form-control" name="finish_date"/>
                <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar">
                    </span>
                </span>
                                </div>
                            </div>
                        </div>

                        <script type="text/javascript">
                            $(function () {
                                $('#datetimepicker2').datetimepicker(
                                        {pickTime: false, language: 'ru'}
                                );
                            });
                        </script>
                        </div>
                        </div>
                        <input type="hidden" name="command" value="get_seances_by_date"/>
                        <input type="submit" value="Найти"/>
            </form>

            <caption>Сеансы</caption>
            <tr>
                <td>Название фильма</td>
                <td>Дата</td>
                <td>Время</td>
                <td>Стоимость</td>
                <td></td>
            </tr>

            <c:forEach var="seance" items="${seances}">
                <tr>
                    <td>${seance.getFilm().getTitle()}</td>
                    <td>${seance.getDateByString()}</td>
                    <td>${seance.getTimeByString()}</td>
                    <td>${seance.getPrice()}</td>
                    <td>
                        <c:choose>
                            <c:when test="${sessionScope.user.getLogin() != null || sessionScope.user.getUserType() != null}">
                                <a class="btn-primary btn-sm"
                                   href="Controller?command=show_buy_ticket_page&seance_id=${seance.getId()}">Купить</a>
                            </c:when>
                            <c:otherwise>
                                <a class="btn-primary btn-sm" href="signin.jsp">Выполните вход</a>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <c:choose>
                        <c:when test="${sessionScope.user.getUserType() != UserType.ADMIN}">
                            <td>
                                <a href="Controller?command=get_seance_by_id&id_seance=${seance.getId()}"><span
                                        class="glyphicon glyphicon-edit"></span></a>
                                <a href="Controller?command=remove_seance&id=${seance.getId()}"><span
                                        class="glyphicon glyphicon-remove"></span></a>
                            </td>
                        </c:when>
                    </c:choose>
                </tr>
            </c:forEach>
        </table>
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
