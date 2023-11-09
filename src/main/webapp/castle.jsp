<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.javarush.quest.zonov.repository.Race" %>
<%@ page import="static com.javarush.quest.zonov.constants.NpcPhrasesConstants.*" %>
<%@ page import="com.javarush.quest.zonov.repository.QuestMode" %>
<%@ page import="static com.javarush.quest.zonov.constants.ButtonsAndFieldsNameConstants.*" %>
<%@ page import="static com.javarush.quest.zonov.constants.UserAnswersConstants.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
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

  <title>Quest Of Heroes - Cave</title>
  <!-- Bootstrap CSS (jsDelivr CDN) -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
  <!-- Bootstrap Bundle JS (jsDelivr CDN) -->
  <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
  <!-- Bootstrap core CSS -->
  <link href="../../css/editor.css" rel="stylesheet">

  <link href="static/castle.css" rel="stylesheet">
</head>
<body style="background-color: rgb(181,184,177); opacity: 1; text-align: center;">
<div class="container">

  <div class="header clearfix">
    <br><br><br>
  </div>
    <%
        String sessionAnswer = (String) session.getAttribute("answer");
        Race race = (Race) session.getAttribute("userRace");
        String userRace = race.getNameOfRace();
        QuestMode mode = (QuestMode) session.getAttribute("mode");
        String probability = (String) session.getAttribute("probability");
    %>
    <c:set var="SESSION_ANSWER" value="<%=sessionAnswer%>" />
    <c:set var="TO_THE_WALL" value="<%=TO_THE_WALL%>"/>
    <c:set var="TO_THE_CANALISATION" value="<%=TO_THE_CANALISATION%>"/>
    <c:set var="CALCULATE_PROBABILITY" value="<%=CALCULATE_PROBABILITY%>"/>
    <c:set var="GO_UPSTAIRS" value="<%=GO_UPSTAIRS%>"/>
    <c:set var="GO_AHEAD" value="<%=GO_AHEAD%>" />
    <c:set var="EXPLODE_THE_WALL" value="<%=EXPLODE_THE_WALL%>" />
    <c:set var="GO_TO_CATACOMBS" value="<%=GO_TO_CATACOMBS%>" />
    <c:set var="CHASING" value="<%=CHASING%>" />
    <c:set var="SESSION_MODE" value="<%=mode%>" />
    <c:set var="SILENT_MODE" value="<%=QuestMode.SILENT_MODE%>" />
    <c:set var="BALDHEADED_MODE" value="<%=QuestMode.BALDHEAD_MODE%>" />

    <c:if test="${mode == SILENT_MODE}">
        <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
            <h2 class="lead" style="text-align: center; text-decoration-style: double;"><b><b><%=ALRIGHT + userRace%>!</b></b></h2>
            <h2 class="lead"><b><b><%=WE_UNDER_THE_WALL%></b></b></h2>
            <c:if test="${SESSION_ANSWER == null}">
                <h3 style="text-align: center" id="answer-button"><%=CHOOSE_OPTION%></h3>
            </c:if>
        </div>
        <br><br>
        <div id="answer">
            <h1><%=YOUR_CHOOSE%></h1>
            <span class="close-btn">
            <img src="https://cdn4.iconfinder.com/data/icons/miu/22/circle_close_delete_-128.png" alt="">
        </span>
            <form action="logic" method="get">
                <input onclick="window.location='/logic?location=castle&mode=silent&answer=0'; closeAfterAnswer()" value="<%=TO_THE_WALL%>" style="cursor:pointer; text-align: center" />
                <input onclick="window.location='/logic?location=castle&mode=silent&answer=1'; closeAfterAnswer()" value="<%=TO_THE_CANALISATION%>" style="cursor:pointer; text-align: center" />
            </form>
        </div>
        <c:if test="${SESSION_ANSWER == TO_THE_WALL}">
            <div class="jumbotron" style="background-color: rgba(85,112,3,0.8); border-radius: 5px; box-shadow: 1px 1px 50px #000;">
                <br>
                <h2 class="lead"><b><b><%=WE_GO_ON_THE_WALL%></b></b></h2>
                <br>
            </div>
            <br><br>
            <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
                <br>
                <h2 class="lead"><b><b><%=I_SEE_HIM%></b></b></h2>
                <br>
            </div>
            <br><br>
            <form action="logic" method="get">
                <input onclick="window.location='/logic?location=castle&mode=silent&answer=2&type=1';closeAfterAnswer()" style="font-size: 30px; text-align: center; cursor: pointer" value="<%=CALCULATE_PROBABILITY%>" />
            </form>
        </c:if>
        <c:if test="${SESSION_ANSWER == CALCULATE_PROBABILITY}">
            <div class="jumbotron" style="background-color: rgba(85,112,3,0.8); border-radius: 5px; box-shadow: 1px 1px 50px #000;">
                <br>
                <h2 class="lead"><b><b><%=WE_GO_ON_THE_WALL%></b></b></h2>
                <br>
            </div>
            <br><br>
            <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
                <br>
                <h2 class="lead"><b><b><%=I_SEE_HIM%></b></b></h2>
                <br>
            </div>
            <br><br>
            <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
                <br>
                <h2 class="display-3"><b><b><%=HIT_PROBABILITY + probability%>%</b></b></h2>
                <br>
            </div>
            <br><br>
            <form action="logic" method="get">
                <input onclick="window.location='/logic?location=castle&mode=silent&answer=3&type=1';closeAfterAnswer()" style="font-size: 30px; text-align: center; cursor: pointer" value="<%=HIT_FROM_AFAR%>" />
                <input onclick="window.location='/logic?location=castle&mode=silent&answer=2&type=1';closeAfterAnswer()" style="font-size: 30px; text-align: center; cursor: pointer" value="<%=TRY_AGAIN%>" />
            </form>
        </c:if>
        <c:if test="${SESSION_ANSWER == TO_THE_CANALISATION}">
            <div class="jumbotron" style="background-color: rgba(85,112,3,0.8); border-radius: 5px; box-shadow: 1px 1px 50px #000;">
                <br>
                <h2 class="lead"><b><b><%=WE_GO_IN_THE_CANALISATION%></b></b></h2>
                <br>
            </div>
            <br><br>
            <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
                <br>
                <h2 class="lead"><b><b><%=GO_FASTER%></b></b></h2>
                <br>
            </div>
            <br><br>
            <form action="logic" method="get">
                <input onclick="window.location='/logic?location=castle&mode=silent&answer=2&type=2';closeAfterAnswer()" style="font-size: 30px; text-align: center; cursor: pointer" value="<%=GO_UPSTAIRS%>" />
            </form>
        </c:if>
        <c:if test="${SESSION_ANSWER == GO_UPSTAIRS}">
            <div class="jumbotron" style="background-color: rgba(85,112,3,0.8); border-radius: 5px; box-shadow: 1px 1px 50px #000;">
                <br>
                <h2 class="lead"><b><b><%=WE_GO_IN_THE_CANALISATION%></b></b></h2>
                <br>
            </div>
            <br><br>
            <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
                <br>
                <h2 class="lead"><b><b><%=GO_FASTER%></b></b></h2>
                <br>
            </div>
            <br><br>
            <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
                <br>
                <h2 class="lead"><b><b><%=KILL_HIM%></b></b></h2>
                <br>
            </div>
            <br><br>
            <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
                <br>
                <h2 class="display-3"><b><b><%=KILL_PROBABILITY + probability%>%</b></b></h2>
                <br>
            </div>
            <br><br>
            <form action="logic" method="get">
                <input onclick="window.location='/logic?location=castle&mode=silent&answer=3&type=2';closeAfterAnswer()" style="font-size: 30px; text-align: center; cursor: pointer" value="<%=KILL_FROM_THE_DOOR%>" />
                <input onclick="window.location='/logic?location=castle&mode=silent&answer=2&type=2';closeAfterAnswer()" style="font-size: 30px; text-align: center; cursor: pointer" value="<%=TRY_AGAIN%>" />
            </form>
        </c:if>

    </c:if>
    <c:if test="${mode == BALDHEADED_MODE}">
        <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
            <h2 class="lead" style="text-align: center; text-decoration-style: double;"><b><b><%=YEAH + userRace%>!</b></b></h2>
            <h2 class="lead"><b><b><%=WE_MAKE_BIG_MESS%></b></b></h2>
            <c:if test="${SESSION_ANSWER == null}">
                <h3 style="text-align: center" id="answer-button"><%=CHOOSE_OPTION%></h3>
            </c:if>
        </div>
        <br><br>
        <div id="answer">
            <h1><%=YOUR_PLAN%></h1>
            <span class="close-btn">
            <img src="https://cdn4.iconfinder.com/data/icons/miu/22/circle_close_delete_-128.png" alt="">
        </span>
            <form action="logic" method="get">
                <input onclick="window.location='/logic?location=castle&mode=baldHead&answer=0'; closeAfterAnswer()" value="<%=GO_AHEAD%>" style="cursor:pointer; text-align: center" />
                <input onclick="window.location='/logic?location=castle&mode=baldHead&answer=1'; closeAfterAnswer()" value="<%=EXPLODE_THE_WALL%>" style="cursor:pointer; text-align: center" />
            </form>
        </div>
        <c:if test="${SESSION_ANSWER == GO_AHEAD}">
            <div class="jumbotron" style="background-color: rgba(85,112,3,0.8); border-radius: 5px; box-shadow: 1px 1px 50px #000;">
                <br>
                <h2 class="lead"><b><b><%=WE_GO_AHEAD%></b></b></h2>
                <br>
            </div>
            <br><br>
            <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
                <br>
                <h2 class="lead"><b><b><%=WE_IN_CASTLE%></b></b></h2>
                <br>
            </div>
            <br><br>
            <form action="logic" method="get">
                <input onclick="window.location='/logic?location=castle&mode=baldHead&answer=2&type=1';closeAfterAnswer()" style="font-size: 30px; text-align: center; cursor: pointer" value="<%=GO_TO_CATACOMBS%>" />
            </form>
        </c:if>
        <c:if test="${SESSION_ANSWER == GO_TO_CATACOMBS}">
            <div class="jumbotron" style="background-color: rgba(85,112,3,0.8); border-radius: 5px; box-shadow: 1px 1px 50px #000;">
                <br>
                <h2 class="lead"><b><b><%=WE_GO_AHEAD%></b></b></h2>
                <br>
            </div>
            <br><br>
            <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
                <br>
                <h2 class="lead"><b><b><%=WE_IN_CASTLE%></b></b></h2>
                <br>
            </div>
            <br><br>
            <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
                <br>
                <h2 class="lead"><b><b><%=WE_IN_THE_CATACOMBS%></b></b></h2>
                <br>
            </div>
            <br><br>
            <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
                <br>
                <h2 class="display-3"><b><b><%=KILL_PROBABILITY + probability%>%</b></b></h2>
                <br>
            </div>
            <br><br>
            <form action="logic" method="get">
                <input onclick="window.location='/logic?location=castle&mode=baldHead&answer=3&type=1';closeAfterAnswer()" style="font-size: 30px; text-align: center; cursor: pointer" value="<%=BLIND_KILL%>" />
                <input onclick="window.location='/logic?location=castle&mode=baldHead&answer=2&type=1';closeAfterAnswer()" style="font-size: 30px; text-align: center; cursor: pointer" value="<%=TRY_AGAIN%>" />
            </form>
        </c:if>
        <c:if test="${SESSION_ANSWER == EXPLODE_THE_WALL}">
            <div class="jumbotron" style="background-color: rgba(85,112,3,0.8); border-radius: 5px; box-shadow: 1px 1px 50px #000;">
                <br>
                <h2 class="lead"><b><b><%=WE_MUST_EXPLODE_THE_WALL%></b></b></h2>
                <br>
            </div>
            <br><br>
            <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
                <br>
                <h2 class="lead"><b><b><%=WALL_EXPLODED%></b></b></h2>
                <br>
            </div>
            <br><br>
            <form action="logic" method="get">
                <input onclick="window.location='/logic?location=castle&mode=baldHead&answer=2&type=2';closeAfterAnswer()" style="font-size: 30px; text-align: center; cursor: pointer" value="<%=CHASING%>" />
            </form>
        </c:if>
        <c:if test="${SESSION_ANSWER == CHASING}">
            <div class="jumbotron" style="background-color: rgba(85,112,3,0.8); border-radius: 5px; box-shadow: 1px 1px 50px #000;">
                <br>
                <h2 class="lead"><b><b><%=WE_MUST_EXPLODE_THE_WALL%></b></b></h2>
                <br>
            </div>
            <br><br>
            <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
                <br>
                <h2 class="lead"><b><b><%=WALL_EXPLODED%></b></b></h2>
                <br>
            </div>
            <br><br>
            <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
                <br>
                <h2 class="lead"><b><b><%=WE_CHASING%></b></b></h2>
                <br>
            </div>
            <br><br>
            <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
                <br>
                <h2 class="display-3"><b><b><%=HIT_PROBABILITY + probability%>%</b></b></h2>
                <br>
            </div>
            <br><br>
            <form action="logic" method="get">
                <input onclick="window.location='/logic?location=castle&mode=baldHead&answer=3&type=2';closeAfterAnswer()" style="font-size: 30px; text-align: center; cursor: pointer" value="<%=KILL_ON_HORSE%>" />
                <input onclick="window.location='/logic?location=castle&mode=baldHead&answer=2&type=2';closeAfterAnswer()" style="font-size: 30px; text-align: center; cursor: pointer" value="<%=TRY_AGAIN%>" />
            </form>
        </c:if>
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
