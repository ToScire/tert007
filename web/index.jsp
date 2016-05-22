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
          <h1>Комфорт обеспечен</h1>
          <p class="lead">Несколько залов, современное оборудование, отзывчивый и дружелюбный персонал. Все это и многое другое вы найдете в нашем кинотеатре. Не упустите возможность по максимому насладиться фильмом</p>
          <p>

              <c:choose>
                  <c:when test="${sessionScope.user.getLogin() == null || sessionScope.user.getUserType() == null}">
                      <a class="btn btn-lg btn-success" href="signin.jsp" role="button">Приобрести билет</a>
                  </c:when>
                  <c:otherwise>
                      <a class="btn btn-lg btn-success" href="Controller?command=get_today_seances" role="button">Приобрести билет</a>
                  </c:otherwise>
              </c:choose>
          </p>
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
