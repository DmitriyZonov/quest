package com.javarush.quest.zonov.servlets;

import com.javarush.quest.zonov.entity.Answer;
import com.javarush.quest.zonov.entity.User;
import com.javarush.quest.zonov.repository.AnswerCode;
import com.javarush.quest.zonov.util.TavernAnswerQualifier;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import static com.javarush.quest.zonov.constants.UserAnswersConstants.*;

@WebServlet(name = "TavernAnswerServlet", value = "/tavernAnswer")
public class TavernAnswerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NullPointerException {
        HttpSession currentSession = req.getSession();

        User user = (User) currentSession.getAttribute("user");

        AnswerCode answerCode = new TavernAnswerQualifier(req).qualifyAnswer();

        switch (answerCode) {
            case ZERO -> {
                currentSession.setAttribute("answer", NOT_YOUR_BUSINESS);
                getServletContext().getRequestDispatcher("/lose.jsp").forward(req, resp);
            }
            case ONE -> {
                currentSession.setAttribute("answer", I_STARVING_FOR_ADVENTURES);
                getServletContext().getRequestDispatcher("/tavern.jsp").forward(req, resp);
            }
            case TWO -> {
                currentSession.setAttribute("answer", GIVE_YOUR_WORK);
                getServletContext().getRequestDispatcher("/tavern.jsp").forward(req, resp);
            }
            case THREE -> {
                currentSession.setAttribute("answer", I_DONT_LIKE_YOU);
                getServletContext().getRequestDispatcher("/lose.jsp").forward(req, resp);
            }
            case FOUR -> getServletContext().getRequestDispatcher("/outsideTavern.jsp").forward(req, resp);
        }


    }
}
