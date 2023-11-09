package com.javarush.quest.zonov.services;

import com.javarush.quest.zonov.repository.AnswerCode;
import com.javarush.quest.zonov.repository.QuestMode;
import com.javarush.quest.zonov.util.StringToModeConverter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import static com.javarush.quest.zonov.constants.AttributesConstants.ANSWER;
import static com.javarush.quest.zonov.constants.AttributesConstants.MODE;
import static com.javarush.quest.zonov.constants.ButtonsAndFieldsNameConstants.CATCH_TRAITOR;
import static com.javarush.quest.zonov.constants.ExceptionConstants.ANSWER_ON_CAVE_EXCEPTION;
import static com.javarush.quest.zonov.constants.ExceptionConstants.MODE_PARAMETER_EXCEPTION;
import static com.javarush.quest.zonov.constants.JSPConstants.*;
import static com.javarush.quest.zonov.constants.UserAnswersConstants.*;

public class CaveAction implements Function {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session, AnswerCode answerCode) throws ServletException, IOException {
        QuestMode mode = new StringToModeConverter(request).convert();

        if (mode == QuestMode.SILENT_MODE) {
            executeSilentMode(request, response, session, answerCode);
        } else if (mode == QuestMode.BALDHEAD_MODE) {
            executeBaldHeadMode(request, response, session, answerCode);
        } else {
            throw new IllegalArgumentException(MODE_PARAMETER_EXCEPTION);
        }
    }

    private void executeSilentMode(HttpServletRequest request, HttpServletResponse response, HttpSession session, AnswerCode answerCode) throws ServletException, IOException {
        switch (answerCode) {
            case ZERO -> {
                session.setAttribute(ANSWER, TELL_HONEST_PLAN);
                request.getServletContext().getRequestDispatcher(LOSE).forward(request, response);
            }
            case ONE -> {
                session.setAttribute(ANSWER, TELL_FAKE_PLAN);
                request.getServletContext().getRequestDispatcher(CAVE).forward(request, response);
            }
            case TWO -> {
                session.setAttribute(ANSWER, CATCH_TRAITOR);
                request.getServletContext().getRequestDispatcher(CAVE).forward(request, response);
            }
            case THREE -> {
                session.setAttribute(ANSWER, null);
                session.setAttribute(MODE, QuestMode.SILENT_MODE);
                request.getServletContext().getRequestDispatcher(CASTLE).forward(request, response);
            }
            case FOUR -> throw new IllegalArgumentException(ANSWER_ON_CAVE_EXCEPTION);
        }
    }

    private void executeBaldHeadMode(HttpServletRequest request, HttpServletResponse response, HttpSession session, AnswerCode answerCode) throws ServletException, IOException {
        switch (answerCode) {
            case ZERO -> {
                session.setAttribute(ANSWER, KILL_ONE_OF_GENERALS);
                request.getServletContext().getRequestDispatcher(CAVE).forward(request, response);
            }
            case ONE -> {
                session.setAttribute(ANSWER, KILL_WIZARD);
                request.getServletContext().getRequestDispatcher(LOSE).forward(request, response);
            }
            case TWO -> {
                session.setAttribute(ANSWER, DO_SILENT);
                request.getServletContext().getRequestDispatcher(CAVE).forward(request, response);
            }
            case THREE -> {
                session.setAttribute(ANSWER, DO_BALDHEAD);
                request.getServletContext().getRequestDispatcher(CAVE).forward(request, response);
            }
            case FOUR -> {
                session.setAttribute(ANSWER, null);
                session.setAttribute(MODE, QuestMode.BALDHEAD_MODE);
                request.getServletContext().getRequestDispatcher(CASTLE).forward(request, response);
            }
        }
    }
}
