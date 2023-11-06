package com.javarush.quest.zonov.services;

import com.javarush.quest.zonov.repository.AnswerCode;
import com.javarush.quest.zonov.repository.QuestMode;
import com.javarush.quest.zonov.util.StringToModeConverter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import static com.javarush.quest.zonov.constants.ButtonsAndFieldsNameConstants.CATCH_TRAITOR;
import static com.javarush.quest.zonov.constants.UserAnswersConstants.*;
import static com.javarush.quest.zonov.constants.UserAnswersConstants.DO_BALDHEAD;

public class CastleAction implements Function {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session, AnswerCode answerCode) throws ServletException, IOException {
        QuestMode mode = new StringToModeConverter(request).convert();

        if (mode == QuestMode.SILENT_MODE) {
            executeSilentMode(request, response, session, answerCode);
        } else if (mode == QuestMode.BALDHEAD_MODE) {
            executeBaldHeadMode(request, response, session, answerCode);
        } else {

        }
    }

    private void executeSilentMode(HttpServletRequest request, HttpServletResponse response, HttpSession session, AnswerCode answerCode) throws ServletException, IOException {
        switch (answerCode) {
            case ZERO -> {
                session.setAttribute("answer", TELL_HONEST_PLAN);
                request.getServletContext().getRequestDispatcher("/lose.jsp").forward(request, response);
            }
            case ONE -> {
                session.setAttribute("answer", TELL_FAKE_PLAN);
                request.getServletContext().getRequestDispatcher("/cave.jsp").forward(request, response);
            }
            case TWO -> {
                session.setAttribute("answer", CATCH_TRAITOR);
                request.getServletContext().getRequestDispatcher("/cave.jsp").forward(request, response);
            }
            case THREE -> {
                session.setAttribute("answer", null);
                session.setAttribute("mode", QuestMode.SILENT_MODE);
                request.getServletContext().getRequestDispatcher("/castle.jsp").forward(request, response);
            }
        }
    }

    private void executeBaldHeadMode(HttpServletRequest request, HttpServletResponse response, HttpSession session, AnswerCode answerCode) throws ServletException, IOException {
        switch (answerCode) {
            case ZERO -> {
                session.setAttribute("answer", KILL_ONE_OF_GENERALS);
                request.getServletContext().getRequestDispatcher("/cave.jsp").forward(request, response);
            }
            case ONE -> {
                session.setAttribute("answer", KILL_WIZARD);
                request.getServletContext().getRequestDispatcher("/lose.jsp").forward(request, response);
            }
            case TWO -> {
                session.setAttribute("answer", DO_SILENT);
                request.getServletContext().getRequestDispatcher("/cave.jsp").forward(request, response);
            }
            case THREE -> {
                session.setAttribute("answer", DO_BALDHEAD);
                request.getServletContext().getRequestDispatcher("/cave.jsp").forward(request, response);
            }
            case FOUR -> {
                session.setAttribute("answer", null);
                session.setAttribute("mode", QuestMode.BALDHEAD_MODE);
                request.getServletContext().getRequestDispatcher("/castle.jsp").forward(request, response);
            }
        }
    }
}
