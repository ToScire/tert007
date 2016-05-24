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
            <c:choose>
                <c:when test="${sessionScope.user.getUserType() eq 'ADMIN'}">
                    <ul class="nav nav-pills pull-right">
                        <li role="presentation"><a href="index.jsp">Главная</a></li>
                        <li role="presentation"><a href="Controller?command=get_today_seances">Сеансы</a></li>
                        <li role="presentation" class="active"><a href="Controller?command=get_films_collection">Фильмы</a></li>
                        <li role="presentation"><a href="Controller?command=get_users_collection">Пользователи</a></li>
                    </ul>
                </c:when>
                <c:otherwise>
                    <ul class="nav nav-pills pull-right">
                        <li role="presentation"><a href="index.jsp">Главная</a></li>
                        <li role="presentation"><a href="Controller?command=get_today_seances">Сеансы</a></li>
                        <li role="presentation" class="active"><a href="Controller?command=get_films_collection">Фильмы</a></li>
                    </ul>
                </c:otherwise>
            </c:choose>
        </nav>
        <jsp:include page="included_user_profile.jsp"/>
    </div>

    <div class="jumbotron">

    <form action="Controller" method="post" class="form-horizontal" role="form">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">Название</label>
            <div class="col-sm-10">
                <input type="text" value="${film.getTitle()}" id="name" name="title" class="form-control"></td>
            </div>
        </div>
        <div class="form-group">
            <label for="description" class="col-sm-2 control-label">Описание</label>
            <div class="col-sm-10">
                <input type="text" value="${film.getDescription()}" id="description" name="description" class="form-control"></td>
            </div>
        </div>

        <div class="form-group">
            <label for="genre" class="col-sm-2 control-label">Жанр</label>
            <div class="col-sm-10">
                <select name="genre" id="genre" class="form-control">
                    <option
                            <c:if test="${film.getGenre() == 'DRAMA'}">
                                selected
                            </c:if>
                            value="DRAMA">DRAMA
                    </option>
                    <option
                            <c:if test="${film.getGenre() == 'COMEDY'}">
                                selected
                            </c:if>
                            value="COMEDY">COMEDY
                    </option>
                </select>
            </div>
        </div>

        <div class="form-group" >
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
                    $('#datetimepicker1').datetimepicker({
                                pickTime: false,
                                language: 'ru'
                    });
                });
            </script>
        </div>


        <div class="form-group">
            <label for="director" class="col-sm-2 control-label">Режиссер</label>
            <div class="col-sm-10">
                <input type="text" value="${film.getDirector()}" id="director" name="director" class="form-control"></td>
            </div>
        </div>

        <div class="form-group">
            <label for="age_limitation" class="col-sm-2 control-label">Жанр</label>
            <div class="col-sm-10">
                <select name="age_limitation" id="age_limitation" class="form-control">
                    <option
                            <c:if test="${film.getAgeLimitation() == 'PG13'}">
                                selected
                            </c:if>
                            value="PG13">PG13
                    </option>
                    <option
                            <c:if test="${film.getAgeLimitation() == 'PG18'}">
                                selected
                            </c:if>
                            value="PG18">PG18
                    </option>
                </select>
            </div>
         </div>
    <input type="hidden" name="command" value="update_film"/>
    <input type="hidden" name="id" value="${film.getId()}">
    <input type="submit" name="button" value="Изменить фильм"/>
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
