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
<table class="table">
    <caption>Все пользователи</caption>
    <tr>
    <td>id</td>
    <td>login</td>
    <td>Email</td>
    <td>Количество бонусов</td>
    <td>Тип пользователя</td>

    </tr>
    <c:forEach var="user" items="${users}">
    <tr>
        <td>${user.getId()}</td>
        <td>${user.getLogin()}</td>
        <td>${user.getEmail()}</td>
        <td>${user.getBonusCount()}</td>
        <td>${user.getUserType()}</td>
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
