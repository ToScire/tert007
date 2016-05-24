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
                <li role="presentation"><a href="Controller?command=get_today_seances">Сеансы</a></li>
                <li role="presentation" class="active"><a href="Controller?command=get_films_collection">Фильмы</a></li>
            </ul>
        </nav>
        <jsp:include page="included_user_profile.jsp"/>
    </div>

    <div class="jumbotron">

        <form action="Controller" method="post" class="form-horizontal" role="form">

            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">Название фильма</label>
                <div class="col-sm-10">
                    <input type="text" value="${ticket.getFilm()}" id="name" class="form-control"></td>
                </div>
            </div>

            <div class="form-group">
                <label for="place" class="col-sm-2 control-label">Место</label>
                <div class="col-sm-10">
                    <select name="place" id="place" class="form-control">
                        <c:forEach var="i" begin="1" end="${seance.getHall().getCapacity()}" step="1">

                            <c:if test="${!busyPlaces.contains(i)}">
                                <option> value="${i}">${i}</option>
                            </c:if>

                            <c:if test="${ticket.getPlace() eq i}">
                                <option selected> value="${i}">${i}</option>
                            </c:if>

                        </c:forEach>
                    </select>
                </div>
            </div>

            <input type="hidden" name="command" value="update_ticket"/>
            <input type="hidden" name="ticket_id" value="${ticket.getId()}">
            <input type="submit" name="button" value="Изменить билет"/>

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
