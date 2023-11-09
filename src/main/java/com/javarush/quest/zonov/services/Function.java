package com.javarush.quest.zonov.services;

import com.javarush.quest.zonov.repository.AnswerCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public interface Function {
    void execute(HttpServletRequest request, HttpServletResponse response, HttpSession session, AnswerCode answerCode) throws ServletException, IOException;
}
