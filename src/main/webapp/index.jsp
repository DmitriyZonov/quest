<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.javarush.quest.zonov.constants.UserAnswersConstants" %>
<!DOCTYPE html>
<head>

    <link href='https://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Arimo' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Hind:300' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300' rel='stylesheet' type='text/css'>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Quest Of Heroes - Main</title>
    <!-- Bootstrap CSS (jsDelivr CDN) -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <!-- Bootstrap Bundle JS (jsDelivr CDN) -->
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    <!-- Bootstrap core CSS -->
    <link href="../../css/editor.css" rel="stylesheet">

    <link href="static/index.css" rel="stylesheet">
</head>

<body style="background-color: rgb(181,184,177); opacity: 1; text-align: center;">

<div class="container">

    <div class="header clearfix">
        <h1 class="text-muted" style="line-height: 62px; font-weight: 800; text-align: center; letter-spacing: 3px;">Quest Of Heroes</h1>
    </div>

    <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
        <h2 class="display-3" style="text-align: center; text-decoration-style: double;"><b>Земля твоих предков в опасности!</b></h2>
        <p class="lead"><b><b>Тебя ждет большое приключение, пройдя которое ты не останешься прежним, ты столкнёшься, возможно, с самым трудным испытанием в твоей жизни, вводи имя, если готов</b></b></p>
        <h3 href="#" id="login-button">Назвать себя</h3>
    </div>

    <div id="container">
        <h1>Введи имя</h1>
        <span class="close-btn">
            <img src="https://cdn4.iconfinder.com/data/icons/miu/22/circle_close_delete_-128.png"></img>
        </span>
        <form action="tavern" method="get">
            <input type="text" name="userName" placeholder="Твоё имя, воин" />
            <select type="text" id="select" name="userRace">
                <option disabled selected>Выбери свою расу</option>
                <option value="elf">Эльф</option>
                <option value="dwarf">Гном</option>
                <option value="wizard">Чародей</option>
                <option value="warrior">Воин</option>
            </select>
            <input type="submit" value="Назвать себя" style="cursor: pointer" />
        </form>
    </div>

    <script src='http://cdnjs.cloudflare.com/ajax/libs/gsap/1.16.1/TweenMax.min.js'></script>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script src="static/login.js"></script>
</div>
</body>
</html>
