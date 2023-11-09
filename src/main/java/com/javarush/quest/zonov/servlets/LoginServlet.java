package com.javarush.quest.zonov.servlets;

import com.javarush.quest.zonov.repository.Race;
import com.javarush.quest.zonov.entity.User;
import com.javarush.quest.zonov.util.StringToRaceConverter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import static com.javarush.quest.zonov.constants.AttributesConstants.*;
import static com.javarush.quest.zonov.constants.JSPConstants.TAVERN;

@WebServlet(name = "LoginServlet", value = "/tavern")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession(true);
        currentSession.setMaxInactiveInterval(-1);

        String name = (req.getParameter(USERNAME));
        Race race = new StringToRaceConverter(req).convert();

        User user = User.getInstance();
        user.setName(name);
        user.setRace(race);

        currentSession.setAttribute(USER, user);
        currentSession.setAttribute(USERNAME, user.getName());
        currentSession.setAttribute(USERRACE, user.getRace());

        getServletContext().getRequestDispatcher(TAVERN).forward(req, resp);
    }
}