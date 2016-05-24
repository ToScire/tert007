<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>

<html>

<!-- Mirrored from getbootstrap.com/examples/jumbotron-narrow/ by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 21 May 2016 20:34:47 GMT -->
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://getbootstrap.com/favicon.ico">

    <title>Narrow Jumbotron Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/jumbotron-narrow.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
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
                        <li role="presentation"  class="active"><a href="Controller?command=get_films_collection">Фильмы</a></li>
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
<table class="table">
    <caption>Фильмы</caption>
    <tr>
        <td>Название</td>
        <td>Описание</td>
        <td>Жанр</td>
        <td>Дата выпуска</td>
        <td>Режиссер</td>
        <td>Возрастные ограничения</td>
        <td></td>
    </tr>

    <c:forEach var="film" items="${films}">
        <tr>
            <td>${film.getTitle()}</td>
            <td>${film.getDescription()}</td>
            <td>${film.getGenre()}</td>
            <td>${film.getDate()}</td>
            <td>${film.getDirector()}</td>
            <td>${film.getAgeLimitation()}</td>
            <td>
                <a class="btn-primary btn-sm"
                   href="Controller?command=find_seances_by_film&film_id=${film.getId()}">Сеансы</a>
                <c:choose>
                    <c:when test="${sessionScope.user.getUserType() != UserType.ADMIN}">
                        <div class="tools">
                            <a href="Controller?command=find_film_by_id&film_id=${film.getId()}"><span
                                    class="glyphicon glyphicon-edit"></span></a>
                            <a href="Controller?command=remove_film&film_id=${film.getId()}"><span
                                    class="glyphicon glyphicon-remove"></span></a>
                        </div>
                    </c:when>
                </c:choose>
            </td>

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

