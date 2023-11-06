package com.javarush.quest.zonov.util;

import com.javarush.quest.zonov.repository.AnswerCode;
import jakarta.servlet.http.HttpServletRequest;

public class AnswerQualifier {

    private int answerCode;

    public AnswerQualifier(HttpServletRequest request){

            String answer = request.getParameter("answer");
            boolean isNumeric = answer.chars().allMatch(Character::isDigit);
            if (isNumeric) {
                this.answerCode = Integer.parseInt(answer);
            }
    }
    public AnswerCode qualifyAnswer() {
        switch(answerCode) {
            case 0 -> {
                return AnswerCode.ZERO;
            }
            case 1 -> {
                return AnswerCode.ONE;
            }
            case 2 -> {
                return AnswerCode.TWO;
            }
            case 3 -> {
                return AnswerCode.THREE;
            }
            case 4 -> {
                return AnswerCode.FOUR;
            }
            default -> {
                return AnswerCode.NONE;
            }
        }
    }
}
