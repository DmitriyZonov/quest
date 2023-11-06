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

@WebServlet(name = "LoginServlet", value = "/tavern")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession(true);
        currentSession.setMaxInactiveInterval(-1);

        String name = (req.getParameter("userName"));
        Race race = new StringToRaceConverter(req).convert();

        User user = User.getInstance();
        user.setName(name);
        user.setRace(race);

        currentSession.setAttribute("user", user);
        currentSession.setAttribute("userName", user.getName());
        currentSession.setAttribute("userRace", user.getRace());

        getServletContext().getRequestDispatcher("/tavern.jsp").forward(req, resp);
    }
}