<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>

<html>
<head>
    <title>Добовление новоого фильма</title>
    <jsp:include page="include_head.jsp"/>
</head>
<body>
<div class="container">
    <div class="header clearfix">
        <nav>
            <c:choose>
                <c:when test="${sessionScope.user.getUserType() eq 'ADMIN'}">
                    <ul class="nav nav-pills pull-right">
                        <li role="presentation"><a href="index.jsp">Главная</a></li>
                        <li role="presentation" class="active"><a href="Controller?command=get_today_seances">Сеансы</a>
                        </li>
                        <li role="presentation"><a href="Controller?command=get_films_collection">Фильмы</a></li>
                        <li role="presentation"><a href="Controller?command=get_users_collection">Пользователи</a></li>
                    </ul>
                </c:when>
                <c:otherwise>
                    <ul class="nav nav-pills pull-right">
                        <li role="presentation"><a href="index.jsp">Главная</a></li>
                        <li role="presentation" class="active"><a href="Controller?command=get_today_seances">Сеансы</a>
                        </li>
                        <li role="presentation"><a href="Controller?command=get_films_collection">Фильмы</a></li>
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
                    <input type="text" value="" id="name" name="title" class="form-control"></td>
                </div>
            </div>
            <div class="form-group">
                <label for="description" class="col-sm-2 control-label">Описание</label>
                <div class="col-sm-10">
                    <input type="text" value="" id="description" name="description"
                           class="form-control"></td>
                </div>
            </div>

            <div class="form-group">
                <label for="genre" class="col-sm-2 control-label">Жанр</label>
                <div class="col-sm-10">
                    <select name="genre" id="genre" class="form-control">
                        <option value="DRAMMA">DRAMMA</option>
                        <option value="COMEDY">COMEDY</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
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
                    <input type="text" value="" id="director" name="director"
                           class="form-control"></td>
                </div>
            </div>

            <div class="form-group">
                <label for="age_limitation" class="col-sm-2 control-label">Жанр</label>
                <div class="col-sm-10">
                    <select name="age_limitation" id="age_limitation" class="form-control">
                        <option value="PG-13">PG-13</option>
                        <option value="PG-18">PG-18</option>
                    </select>
                </div>
            </div>
            <input type="hidden" name="command" value="update_film"/>
            <input type="submit" name="button" value="Добавить"/>
        </form>
    </div>
</div>
</body>
</html>

