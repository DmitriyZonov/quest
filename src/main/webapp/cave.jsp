<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.javarush.quest.zonov.util.UserRaceInGenitiveCase" %>
<%@ page import="com.javarush.quest.zonov.repository.Race" %>
<%@ page import="com.javarush.quest.zonov.util.WeaponToRace" %>
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

    <link href="static/cave.css" rel="stylesheet">
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
        String userRaceInGenitiveCase = new UserRaceInGenitiveCase(race).toGenitive();
        String weapon = new WeaponToRace(race).correlate();
        QuestMode mode = (QuestMode) session.getAttribute("mode");
    %>
    <c:set var="SESSION_ANSWER" value="<%=sessionAnswer%>" />
    <c:set var="FAKE_PLAN" value="<%=TELL_FAKE_PLAN%>"/>
    <c:set var="CATCH_TRAITOR" value="<%=CATCH_TRAITOR%>"/>
    <c:set var="KILL_ONE_OF_GENERALS" value="<%=KILL_ONE_OF_GENERALS%>"/>
    <c:set var="DO_SILENT" value="<%=DO_SILENT%>"/>
    <c:set var="DO_BALDHEAD" value="<%=DO_BALDHEAD%>"/>
    <c:set var="SESSION_MODE" value="<%=mode%>" />
    <c:set var="SILENT_MODE" value="<%=QuestMode.SILENT_MODE%>" />
    <c:set var="BALDHEADED_MODE" value="<%=QuestMode.BALDHEAD_MODE%>" />

    <c:if test="${mode == SILENT_MODE}">
        <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
            <h2 class="lead" style="text-align: center; text-decoration-style: double;"><b><b><%=WELL_DONE + userRace%>!</b></b></h2>
            <h2 class="lead"><b><b><%=WE_WILL_WIN_SOON + userRaceInGenitiveCase%></b></b></h2>
            <c:if test="${SESSION_ANSWER == null}">
                <h3 style="text-align: center" id="answer-button"><%=TELL_YOUR_PLAN%></h3>
            </c:if>
        </div>
        <br><br>
            <div id="answer">
                <h1><%=YOUR_ANSWER%></h1>
                <span class="close-btn">
            <img src="https://cdn4.iconfinder.com/data/icons/miu/22/circle_close_delete_-128.png" alt="">
        </span>
                <form action="logic" method="get">
                    <input onclick="window.location='/logic?location=cave&mode=silent&answer=0'; closeAfterAnswer()" value="<%=TELL_HONEST_PLAN%>" style="cursor:pointer; text-align: center" />
                    <input onclick="window.location='/logic?location=cave&mode=silent&answer=1'; closeAfterAnswer()" value="<%=TELL_FAKE_PLAN%>" style="cursor:pointer; text-align: center" />
                </form>
            </div>
        <c:if test="${SESSION_ANSWER == FAKE_PLAN}">
            <div class="jumbotron" style="background-color: rgba(85,112,3,0.8); border-radius: 5px; box-shadow: 1px 1px 50px #000;">
                <h2 class="lead"><b><b><%=PLAN_SILENT_MODE + MY + weapon + SMELLS_BETRAYAL%></b></b></h2>
            </div>
            <br><br>
            <form action="logic" method="get">
                <input onclick="window.location='/logic?location=cave&mode=silent&answer=2';closeAfterAnswer()" style="font-size: 30px; text-align: center; cursor: pointer" value="<%=CATCH_TRAITOR%>" />
            </form>
        </c:if>
        <c:if test="${SESSION_ANSWER == CATCH_TRAITOR}">
            <div class="jumbotron" style="background-color: rgba(85,112,3,0.8); border-radius: 5px; box-shadow: 1px 1px 50px #000;">
                <h2 class="lead"><b><b><%=PLAN_SILENT_MODE + MY + weapon + SMELLS_BETRAYAL%></b></b></h2>
            </div>
            <br><br>
            <div class="jumbotron" style="background-color: rgba(85,112,3,0.8); border-radius: 5px; box-shadow: 1px 1px 50px #000;">
                <h2 class="lead"><b><b><%=GOTCHA%></b></b></h2>
            </div>
            <br><br>
            <form action="logic" method="get">
                <input onclick="window.location='/logic?location=cave&mode=silent&answer=3';closeAfterAnswer()" style="font-size: 30px; text-align: center; cursor: pointer" value="<%=GO_TO_CASTLE%>" />
            </form>
        </c:if>
    </c:if>
    <c:if test="${mode == BALDHEADED_MODE}">
        <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;" >
            <h2 class="lead" style="text-align: center; text-decoration-style: double;"><b><b><%=YOU_WANNA_FIGHT + userRace%>!</b></b></h2>
            <h2 class="lead"><b><b><%=THIS_IS_THAT_DAY%></b></b></h2>
            <c:if test="${SESSION_ANSWER == null}">
                <h3 style="text-align: center" id="answer-button"><%=TELL_ABOUT_YOUR_FEELINGS%></h3>
            </c:if>
        </div>
        <br><br>
        <div id="answer">
            <h1><%=YOUR_ANSWER%></h1>
            <span class="close-btn">
            <img src="https://cdn4.iconfinder.com/data/icons/miu/22/circle_close_delete_-128.png" alt="">
        </span>
            <form action="logic" method="get">
                <input onclick="window.location='/logic?location=cave&mode=baldHead&answer=0'; closeAfterAnswer()" value="<%=KILL_ONE_OF_GENERALS%>" style="cursor:pointer; text-align: center" />
                <input onclick="window.location='/logic?location=cave&mode=baldHead&answer=1'; closeAfterAnswer()" value="<%=KILL_WIZARD%>" style="cursor:pointer; text-align: center" />
            </form>
        </div>
        <br><br>
        <c:if test="${SESSION_ANSWER == KILL_ONE_OF_GENERALS}">
            <div class="jumbotron" style="background-color: rgba(85,112,3,0.8); border-radius: 5px; box-shadow: 1px 1px 50px #000;">
                <h2 class="lead"><b><b><%=KILL_RATS%></b></b></h2>
            </div>
            <br><br>
            <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;">
                <h2 class="lead"><b><b><%=WE_GO_WITH_YOU%></b></b></h2>
            </div>
            <br><br>
            <form action="logic" method="get">
                <input onclick="window.location='/logic?location=cave&mode=baldHead&answer=2';closeAfterAnswer()" style="font-size: 30px; text-align: center; cursor: pointer" value="<%=DO_SILENT%>" />
                <input onclick="window.location='/logic?location=cave&mode=baldHead&answer=3';closeAfterAnswer()" style="font-size: 30px; text-align: center; cursor: pointer" value="<%=DO_BALDHEAD%>" />
            </form>
        </c:if>
        <c:if test="${SESSION_ANSWER == DO_SILENT}">
            <div class="jumbotron" style="background-color: rgba(85,112,3,0.8); border-radius: 5px; box-shadow: 1px 1px 50px #000;">
                <h2 class="lead"><b><b><%=KILL_RATS%></b></b></h2>
            </div>
            <br><br>
            <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;">
                <h2 class="lead"><b><b><%=WE_GO_WITH_YOU%></b></b></h2>
            </div>
            <br><br>
            <div class="jumbotron" style="background-color: rgba(85,112,3,0.8); border-radius: 5px; box-shadow: 1px 1px 50px #000;">
                <h2 class="lead"><b><b><%=I_TIRED_AND_WANT_SILENT%></b></b></h2>
            </div>
            <br><br>
            <input onclick="window.location='/logic?location=cave&mode=silent&answer=3';closeAfterAnswer()" style="font-size: 30px; text-align: center; cursor: pointer" value="<%=GO_TO_CASTLE%>" />
        </c:if>
        <c:if test="${SESSION_ANSWER == DO_BALDHEAD}">
            <div class="jumbotron" style="background-color: rgba(85,112,3,0.8); border-radius: 5px; box-shadow: 1px 1px 50px #000;">
                <h2 class="lead"><b><b><%=KILL_RATS%></b></b></h2>
            </div>
            <br><br>
            <div class="jumbotron" style="background-color: rgba(203, 212, 220, .50); border-radius: 5px; box-shadow: 1px 1px 50px #000;">
                <br>
                <h2 class="lead"><b><b><%=WE_GO_WITH_YOU%></b></b></h2>
                <br>
            </div>
            <br><br>
            <div class="jumbotron" style="background-color: rgba(85,112,3,0.8); border-radius: 5px; box-shadow: 1px 1px 50px #000;">
                <h2 class="lead"><b><b><%=NONSENSE%></b></b></h2>
            </div>
            <br><br>
            <input onclick="window.location='/logic?location=cave&mode=baldHead&answer=4';closeAfterAnswer()" style="font-size: 30px; text-align: center; cursor: pointer" value="<%=ATTACK_CASTLE%>" />
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
