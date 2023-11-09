package com.javarush.quest.zonov.services;

import com.javarush.quest.zonov.constants.UserAnswersConstants;
import com.javarush.quest.zonov.repository.AnswerCode;
import com.javarush.quest.zonov.repository.QuestMode;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import static com.javarush.quest.zonov.constants.AttributesConstants.ANSWER;
import static com.javarush.quest.zonov.constants.AttributesConstants.MODE;
import static com.javarush.quest.zonov.constants.ExceptionConstants.ANSWER_ON_OUTSIDE_TAVERN_EXCEPTION;
import static com.javarush.quest.zonov.constants.JSPConstants.CAVE;
import static com.javarush.quest.zonov.constants.JSPConstants.OUTSIDE_TAVERN;

public class OutsideTavernAction implements Function {


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session, AnswerCode answerCode) throws ServletException, IOException {
        switch (answerCode) {
            case ZERO -> {
                session.setAttribute(ANSWER, UserAnswersConstants.SILENT_MODE);
                request.getServletContext().getRequestDispatcher(OUTSIDE_TAVERN).forward(request, response);
            }
            case ONE -> {
                session.setAttribute(ANSWER, UserAnswersConstants.BALDHEADED_MODE);
                request.getServletContext().getRequestDispatcher(OUTSIDE_TAVERN).forward(request, response);
            }
            case TWO -> {
                session.setAttribute(ANSWER, null);
                session.setAttribute(MODE, QuestMode.SILENT_MODE);
                request.getServletContext().getRequestDispatcher(CAVE).forward(request, response);
            }
            case THREE -> {
                session.setAttribute(ANSWER, null);
                session.setAttribute(MODE, QuestMode.BALDHEAD_MODE);
                request.getServletContext().getRequestDispatcher(CAVE).forward(request, response);
            }
            case FOUR -> throw new IllegalArgumentException(ANSWER_ON_OUTSIDE_TAVERN_EXCEPTION);
        }
    }
}
