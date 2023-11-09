<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="com.javarush.quest.zonov.constants.UserAnswersConstants" %>
<%@ page import="com.javarush.quest.zonov.repository.Race" %>
<%@ page import="com.javarush.quest.zonov.util.UserRaceInGenitiveCase" %>
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

    <title>Quest Of Heroes - Tavern</title>
    <!-- Bootstrap CSS (jsDelivr CDN) -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <!-- Bootstrap Bundle JS (jsDelivr CDN) -->
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    <!-- Bootstrap core CSS -->
    <link href="../../css/editor.css" rel="stylesheet">

    <link href="static/tavern.css" rel="stylesheet">
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
        String userRaceInGenitiveCase = new UserRaceInGenitiveCase(race).toGenitive();
    %>
    <c:set var="TAVERN_GOOD_ANSWER" value="<%=I_STARVING_FOR_ADVENTURES%>"/>
    <c:set var="GO_TO_THE_QUEST" value="<%=UserAnswersConstants.GIVE_YOUR_WORK%>"/>
    <c:set var="SESSION_ANSWER" value="<%=sessionAnswer%>" />

<div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
    <h2 class="lead" style="text-align: center; text-decoration-style: double;"><b><b><%=GREETINGS + userRace%>!</b></b></h2>
    <h2 class="lead"><b><b><%=WHAT_ARE_YOU_DOING_HERE%></b></b></h2>
    <c:if test="${SESSION_ANSWER == null}">
    <h3 style="text-align: center" href="#" id="answer-button"><%=ANSWER_TO_INNKEAPER%></h3>
    </c:if>
</div>
    <br><br>
    <div id="answer">
        <h1><%=YOUR_ANSWER%></h1>
        <span class="close-btn">
            <img src="https://cdn4.iconfinder.com/data/icons/miu/22/circle_close_delete_-128.png">
        </span>
        <form action="logic" method="get">
            <input onclick="window.location='/logic?location=tavern&answer=0'" value="<%=NOT_YOUR_BUSINESS%>" style="cursor:pointer; text-align: center" />
            <input onclick="window.location='/logic?location=tavern&answer=1'; closeAfterAnswer()" value="<%=I_STARVING_FOR_ADVENTURES%>" style="cursor:pointer; text-align: center" />
        </form>
    </div>

    <c:if test="${SESSION_ANSWER == TAVERN_GOOD_ANSWER}">
        <div class="jumbotron" style="background-color: rgba(10,145,9,0.5); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
            <br>
            <h2 class="lead" style="text-align: center; text-decoration-style: double;"><b><b>${TAVERN_GOOD_ANSWER}</b></b></h2>
            <br>
        </div>
        <br><br>
        <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
            <h2 class="lead" style="text-align: center; text-decoration-style: double;"><b><b><%=THATS_GOOD%></b></b></h2>
            <h2 class="lead"><b><b><%=I_HAVE_A_JOB + userRaceInGenitiveCase%></b></b></h2>
        </div>
        <br><br>
        <h1><%=ANSWER_ON_CALL%></h1>
        <form action="logic" method="get">
            <input onclick="window.location='/logic?location=tavern&answer=2'" value="<%=GIVE_YOUR_WORK%>" style="cursor:pointer; text-align: center" />
            <input onclick="window.location='/logic?location=tavern&answer=3'; closeAfterAnswer()" value="<%=I_DONT_LIKE_YOU%>" style="cursor:pointer; text-align: center" />
        </form>
    </c:if>

    <c:if test="${GO_TO_THE_QUEST == SESSION_ANSWER}">
        <div class="jumbotron" style="background-color: rgba(10,145,9,0.5); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
            <br>
            <h2 class="lead" style="text-align: center; text-decoration-style: double;"><b><b>${TAVERN_GOOD_ANSWER}</b></b></h2>
            <br>
        </div>
        <br><br>
        <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
            <h2 class="lead" style="text-align: center; text-decoration-style: double;"><b><b><%=THATS_GOOD%></b></b></h2>
            <h2 class="lead"><b><b><%=I_HAVE_A_JOB + userRaceInGenitiveCase%></b></b></h2>
        </div>
        <br><br>
        <div class="jumbotron" style="background-color: rgba(10,145,9,0.5); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
            <br>
            <h2 class="lead" style="text-align: center; text-decoration-style: double;"><b><b>${GO_TO_THE_QUEST}</b></b></h2>
            <br>
        </div>
        <br><br>
        <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
            <br>
            <h2 class="lead"><b><b><%=GO_IF_YOU_READY%></b></b></h2>
            <br>
        </div>
        <br><br>
        <form action="logic" method="get">
            <input onclick="window.location='/logic?location=tavern&answer=4'" style="font-size: 30px; text-align: center; cursor: pointer" value="<%=GO_FOR_INNKEAPER%>" />
        </form>
    </c:if>

    <script src='http://cdnjs.cloudflare.com/ajax/libs/gsap/1.16.1/TweenMax.min.js'></script>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script src="static/answer.js"></script>
    <script>
        function closeAfterAnswer(){
            TweenMax.from("#answer", .4, { scale: 1, ease:Sine.easeInOut});
            TweenMax.to("#answer", .4, { left:"0px", scale: 0, ease:Sine.easeInOut});
        }
    </script>

</div>
</body>
