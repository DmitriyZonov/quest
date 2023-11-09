<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.javarush.quest.zonov.repository.Race" %>
<%@ page import="static com.javarush.quest.zonov.constants.ButtonsAndFieldsNameConstants.*" %>
<%@ page import="static com.javarush.quest.zonov.constants.NpcPhrasesConstants.*" %>
<%@ page import="com.javarush.quest.zonov.util.WeaponToRace" %>

<!DOCTYPE html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <link href='https://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Arimo' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Hind:300' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300' rel='stylesheet' type='text/css'>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Quest Of Heroes - You Lose</title>
    <!-- Bootstrap CSS (jsDelivr CDN) -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <!-- Bootstrap Bundle JS (jsDelivr CDN) -->
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    <!-- Bootstrap core CSS -->
    <link href="../../css/editor.css" rel="stylesheet">

    <link href="static/win.css" rel="stylesheet">
</head>
<body style="background-color: rgb(181,184,177); opacity: 1; text-align: center;">
<div class="container">

    <div class="header clearfix">
        <br>
    </div>
        <%
        String sessionAnswer = (String) session.getAttribute("answer");
        String userName = (String) session.getAttribute("userName");
        Race race = (Race) session.getAttribute("userRace");
        String userRace = race.getNameOfRace();
        String weapon = new WeaponToRace(race).correlate();
    %>
    <c:set var="HIT_FROM_AFAR" value="<%=HIT_FROM_AFAR%>" />
    <c:set var="KILL_FROM_THE_DOOR" value="<%=KILL_FROM_THE_DOOR%>" />
    <c:set var="BLIND_KILL" value="<%=BLIND_KILL%>" />
    <c:set var="HORSE_KILL" value="<%=KILL_ON_HORSE%>" />
    <c:set var="SESSION_ANSWER" value="<%=sessionAnswer%>" />

    <c:if test="${SESSION_ANSWER == HIT_FROM_AFAR}">
        <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
            <h2 class="display-3" style="text-align: center; text-decoration-style: double;"><b><%=CONGRATULATIONS + userName%></b></h2>
            <p class="lead"><b><b><%=IT_WAS_AMAZING + weapon + AFTER_HIT_AFAR + userRace%></b></b></p>
        </div>
    </c:if>
    <c:if test="${SESSION_ANSWER == KILL_FROM_THE_DOOR}">
        <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
            <h2 class="display-3" style="text-align: center; text-decoration-style: double;"><b><%=CONGRATULATIONS + userName%></b></h2>
            <p class="lead"><b><b><%=IT_WAS_AMAZING + weapon + AFTER_KILLING_FROM_DOOR + userRace%></b></b></p>
        </div>
    </c:if>
    <c:if test="${SESSION_ANSWER == BLIND_KILL}">
        <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
            <h2 class="display-3" style="text-align: center; text-decoration-style: double;"><b><%=CONGRATULATIONS + userName%></b></h2>
            <p class="lead"><b><b><%=YOU_ARE_GREAT_WARRIOR + weapon + AFTER_BLIND_KILL + userRace%></b></b></p>
        </div>
    </c:if>
    <c:if test="${SESSION_ANSWER == HORSE_KILL}">
        <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
            <h2 class="display-3" style="text-align: center; text-decoration-style: double;"><b><%=CONGRATULATIONS + userName%></b></h2>
            <p class="lead"><b><b><%=AFTER_KILL_ON_HORSE + userRace%></b></b></p>
        </div>
    </c:if>
    <form action="restart" method="post">
        <input type="submit" style="font-size: 20px" id="answer-button" value="<%=RESTART_AFTER_WIN%>" />
    </form>
</div>
</body>
