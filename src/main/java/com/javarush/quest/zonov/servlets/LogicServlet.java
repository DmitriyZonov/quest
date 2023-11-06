package com.javarush.quest.zonov.servlets;

import com.javarush.quest.zonov.repository.AnswerCode;
import com.javarush.quest.zonov.repository.Location;
import com.javarush.quest.zonov.services.Function;
import com.javarush.quest.zonov.util.AnswerQualifier;
import com.javarush.quest.zonov.util.LocationToFunction;
import com.javarush.quest.zonov.util.StringToLocationConverter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LogicServlet", value = "/logic")
public class LogicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NullPointerException {
        HttpSession currentSession = req.getSession();
        AnswerCode answerCode = new AnswerQualifier(req).qualifyAnswer();
        Location location = new StringToLocationConverter(req).convert();

        Function function = new LocationToFunction(location).convert();

        function.execute(req, resp, currentSession, answerCode);
    }
}
