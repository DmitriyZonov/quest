package com.javarush.quest.zonov.services;

import com.javarush.quest.zonov.constants.UserAnswersConstants;
import com.javarush.quest.zonov.repository.AnswerCode;
import com.javarush.quest.zonov.repository.QuestMode;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class OutsideTavernAction implements Function {


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session, AnswerCode answerCode) throws ServletException, IOException {
        switch (answerCode) {
            case ZERO -> {
                session.setAttribute("answer", UserAnswersConstants.SILENT_MODE);
                request.getServletContext().getRequestDispatcher("/outsideTavern.jsp").forward(request, response);
            }
            case ONE -> {
                session.setAttribute("answer", UserAnswersConstants.BALDHEADED_MODE);
                request.getServletContext().getRequestDispatcher("/outsideTavern.jsp").forward(request, response);
            }
            case TWO -> {
                session.setAttribute("answer", null);
                session.setAttribute("mode", QuestMode.SILENT_MODE);
                request.getServletContext().getRequestDispatcher("/cave.jsp").forward(request, response);
            }
            case THREE -> {
                session.setAttribute("answer", null);
                session.setAttribute("mode", QuestMode.BALDHEAD_MODE);
                request.getServletContext().getRequestDispatcher("/cave.jsp").forward(request, response);
            }
        }
    }
}
