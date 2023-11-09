package com.javarush.quest.zonov.services;

import com.javarush.quest.zonov.repository.AnswerCode;
import com.javarush.quest.zonov.repository.QuestMode;
import com.javarush.quest.zonov.repository.WinCode;
import com.javarush.quest.zonov.util.HitProbabilityMonitor;
import com.javarush.quest.zonov.util.StringToModeConverter;
import com.javarush.quest.zonov.util.WinQualifier;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import static com.javarush.quest.zonov.constants.AttributesConstants.*;
import static com.javarush.quest.zonov.constants.ButtonsAndFieldsNameConstants.*;
import static com.javarush.quest.zonov.constants.ExceptionConstants.*;
import static com.javarush.quest.zonov.constants.JSPConstants.*;
import static com.javarush.quest.zonov.constants.UserAnswersConstants.*;

public class CastleAction implements Function {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session, AnswerCode answerCode) throws ServletException, IOException {
        QuestMode mode = new StringToModeConverter(request).convert();
        switch (mode) {
            case SILENT_MODE -> executeSilentMode(request, response, session, answerCode);
            case BALDHEAD_MODE -> executeBaldHeadMode(request, response, session, answerCode);
        }
    }

    private void executeSilentMode(HttpServletRequest request, HttpServletResponse response, HttpSession session, AnswerCode answerCode) throws ServletException, IOException {
        switch (answerCode) {
            case ZERO -> {
                session.setAttribute(ANSWER, TO_THE_WALL);
            request.getServletContext().getRequestDispatcher(CASTLE).forward(request, response);
            }
            case ONE -> {
                session.setAttribute(ANSWER, TO_THE_CANALISATION);
                request.getServletContext().getRequestDispatcher(CASTLE).forward(request, response);
            }
            case TWO -> {
                int type = Integer.parseInt(request.getParameter(TYPE));
                switch (type) {
                    case 1 -> session.setAttribute(ANSWER, CALCULATE_PROBABILITY);
                    case 2 -> session.setAttribute(ANSWER, GO_UPSTAIRS);
                    default -> throw new IllegalArgumentException(TYPE_PARAMETER_EXCEPTION);
                }
                session.setAttribute(PROBABILITY, new HitProbabilityMonitor().analyzeProbability());
                request.getServletContext().getRequestDispatcher(CASTLE).forward(request, response);
            }
            case THREE -> {
                int type = Integer.parseInt(request.getParameter(TYPE));
                switch (type) {
                    case 1 -> session.setAttribute(ANSWER, HIT_FROM_AFAR);
                    case 2 -> session.setAttribute(ANSWER, KILL_FROM_THE_DOOR);
                    default -> throw new IllegalArgumentException(TYPE_PARAMETER_EXCEPTION);
                }

                WinCode winCode = new WinQualifier(request).qualifyWin();
                switch (winCode) {
                    case WIN -> request.getServletContext().getRequestDispatcher(WIN).forward(request, response);
                    case LOSE -> request.getServletContext().getRequestDispatcher(LOSE).forward(request, response);
                }
            }
            case FOUR -> throw new IllegalArgumentException(ANSWER_ON_CASTLE_EXCEPTION);
        }
    }

    private void executeBaldHeadMode(HttpServletRequest request, HttpServletResponse response, HttpSession session, AnswerCode answerCode) throws ServletException, IOException {
        switch (answerCode) {
            case ZERO -> {
                session.setAttribute(ANSWER, GO_AHEAD);
                request.getServletContext().getRequestDispatcher(CASTLE).forward(request, response);
            }
            case ONE -> {
                session.setAttribute(ANSWER, EXPLODE_THE_WALL);
                request.getServletContext().getRequestDispatcher(CASTLE).forward(request, response);
            }
            case TWO -> {
                int type = Integer.parseInt(request.getParameter(TYPE));
                switch (type) {
                    case 1 -> session.setAttribute(ANSWER, GO_TO_CATACOMBS);
                    case 2 -> session.setAttribute(ANSWER, CHASING);
                    default -> throw new IllegalArgumentException(TYPE_PARAMETER_EXCEPTION);
                }
                session.setAttribute(PROBABILITY, new HitProbabilityMonitor().analyzeProbability());
                request.getServletContext().getRequestDispatcher(CASTLE).forward(request, response);
            }
            case THREE -> {
                int type = Integer.parseInt(request.getParameter(TYPE));
                switch (type) {
                    case 1 -> session.setAttribute(ANSWER, BLIND_KILL);
                    case 2 -> session.setAttribute(ANSWER, KILL_ON_HORSE);
                    default -> throw new IllegalArgumentException(TYPE_PARAMETER_EXCEPTION);
                }

                WinCode winCode = new WinQualifier(request).qualifyWin();
                switch (winCode) {
                    case WIN -> request.getServletContext().getRequestDispatcher(WIN).forward(request, response);
                    case LOSE -> request.getServletContext().getRequestDispatcher(LOSE).forward(request, response);
                }
            }
            case FOUR -> throw new IllegalArgumentException(ANSWER_ON_CASTLE_EXCEPTION);
        }
    }
}
