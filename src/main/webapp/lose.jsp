<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.javarush.quest.zonov.repository.Race" %>
<%@ page import="static com.javarush.quest.zonov.constants.ButtonsAndFieldsNameConstants.*" %>
<%@ page import="static com.javarush.quest.zonov.constants.NpcPhrasesConstants.*" %>
<%@ page import="static com.javarush.quest.zonov.constants.UserAnswersConstants.*" %>

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

    <link href="static/lose.css" rel="stylesheet">
</head>
<body style="background-color: rgb(181,184,177); opacity: 1; text-align: center;">
<div class="container">

    <div class="header clearfix">
        <br><br><br><br><br><br>
    </div>
    <%
        String sessionAnswer = (String) session.getAttribute("answer");
        Race race = (Race) session.getAttribute("userRace");
        String userRace = race.getNameOfRace();
    %>
    <c:set var="FIRST_TAVERN_BAD_ANSWER" value="<%=NOT_YOUR_BUSINESS%>" />
    <c:set var="SECOND_TAVERN_BAD_ANSWER" value="<%=I_DONT_LIKE_YOU%>" />
    <c:set var="HONEST_PLAN" value="<%=TELL_HONEST_PLAN%>"/>
    <c:set var="KILL_WIZARD" value="<%=KILL_WIZARD%>"/>
    <c:set var="SESSION_ANSWER" value="<%=sessionAnswer%>"/>
    <c:if test="${SESSION_ANSWER == FIRST_TAVERN_BAD_ANSWER}">

    <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
        <h2 class="lead" style="text-align: center; text-decoration-style: double;"><b><b><%=SORRY + userRace%>!</b></b></h2>
        <h2 class="lead"><b><b><%=YOURE_KILLED_BY_INNKEAPER%></b></b></h2>
    </div>
    </c:if>
    <c:if test="${SESSION_ANSWER == SECOND_TAVERN_BAD_ANSWER}">
        <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
            <h2 class="lead" style="text-align: center; text-decoration-style: double;"><b><b><%=SORRY + userRace%>!</b></b></h2>
            <h2 class="lead"><b><b><%=BE_POLITE%></b></b></h2>
        </div>
    </c:if>
    <c:if test="${SESSION_ANSWER == HONEST_PLAN}">
        <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
            <h2 class="lead" style="text-align: center; text-decoration-style: double;"><b><b><%=SORRY + userRace%>!</b></b></h2>
            <h2 class="lead"><b><b><%=TOO_HONEST%></b></b></h2>
        </div>
    </c:if>
    <c:if test="${SESSION_ANSWER == KILL_WIZARD}">
        <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
            <h2 class="lead" style="text-align: center; text-decoration-style: double;"><b><b><%=SORRY + userRace%>!</b></b></h2>
            <h2 class="lead"><b><b><%=YOU_ARE_PARANOID%></b></b></h2>
        </div>
    </c:if>
    <br><br><br><br><br><br>
    <form action="restart" method="post">
        <input type="submit" style="font-size: 30px" id="answer-button" value="<%=RESTART%>" />
    </form>
</div>

</body>
</html>
