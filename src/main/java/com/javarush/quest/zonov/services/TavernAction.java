package com.javarush.quest.zonov.services;

import com.javarush.quest.zonov.repository.AnswerCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import static com.javarush.quest.zonov.constants.AttributesConstants.ANSWER;
import static com.javarush.quest.zonov.constants.JSPConstants.*;
import static com.javarush.quest.zonov.constants.UserAnswersConstants.*;
import static com.javarush.quest.zonov.constants.UserAnswersConstants.I_DONT_LIKE_YOU;

public class TavernAction implements Function {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session, AnswerCode answerCode) throws ServletException, IOException {
        switch (answerCode) {
            case ZERO -> {
                session.setAttribute(ANSWER, NOT_YOUR_BUSINESS);
                request.getServletContext().getRequestDispatcher(LOSE).forward(request, response);
            }
            case ONE -> {
                session.setAttribute(ANSWER, I_STARVING_FOR_ADVENTURES);
                request.getServletContext().getRequestDispatcher(TAVERN).forward(request, response);
            }
            case TWO -> {
                session.setAttribute(ANSWER, GIVE_YOUR_WORK);
                request.getServletContext().getRequestDispatcher(TAVERN).forward(request, response);
            }
            case THREE -> {
                session.setAttribute(ANSWER, I_DONT_LIKE_YOU);
                request.getServletContext().getRequestDispatcher(LOSE).forward(request, response);
            }
            case FOUR -> {
                session.setAttribute(ANSWER, null);
                request.getServletContext().getRequestDispatcher(OUTSIDE_TAVERN).forward(request, response);
            }
        }
    }
}
