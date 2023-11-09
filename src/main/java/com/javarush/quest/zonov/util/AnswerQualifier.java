package com.javarush.quest.zonov.util;

import com.javarush.quest.zonov.repository.AnswerCode;
import jakarta.servlet.http.HttpServletRequest;

import static com.javarush.quest.zonov.constants.AttributesConstants.ANSWER;
import static com.javarush.quest.zonov.constants.ExceptionConstants.*;
import static java.util.Objects.isNull;

public class AnswerQualifier {

    private int answerCode;

    public AnswerQualifier(HttpServletRequest request){
        if(isNull(request)){
            throw new IllegalArgumentException(REQUEST_NOT_NULL);
        } else {
            String answer = request.getParameter(ANSWER);
            if (new StringLegacyChecker(ANSWER).check()) {
                boolean isNumeric = answer.chars().allMatch(Character::isDigit);
                if (isNumeric) {
                    this.answerCode = Integer.parseInt(answer);
                } else {
                    throw new IllegalStateException(ANSWER_STATE_EXCEPTION);
                }
            }
        }
    }
    public AnswerCode qualifyAnswer() {
        return switch (answerCode) {
            case 0 -> AnswerCode.ZERO;
            case 1 -> AnswerCode.ONE;
            case 2 -> AnswerCode.TWO;
            case 3 -> AnswerCode.THREE;
            case 4 -> AnswerCode.FOUR;
            default -> throw new IllegalStateException(ANSWERCODE_ILLEGAL_STATE + answerCode);
        };
    }
}
