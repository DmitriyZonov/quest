package com.javarush.quest.zonov.util;

import com.javarush.quest.zonov.repository.WinCode;
import jakarta.servlet.http.HttpServletRequest;

import static com.javarush.quest.zonov.constants.AttributesConstants.PROBABILITY;
import static com.javarush.quest.zonov.constants.ExceptionConstants.PROBABILITY_STATE_EXCEPTION;
import static com.javarush.quest.zonov.constants.ExceptionConstants.REQUEST_NOT_NULL;
import static java.util.Objects.isNull;

public class WinQualifier {
    private int probability;

    public WinQualifier(HttpServletRequest request) {
        if(isNull(request)){
            throw new IllegalArgumentException(REQUEST_NOT_NULL);
        } else {
            String probability = (String) request.getSession().getAttribute(PROBABILITY);
            boolean isNumeric = probability.chars().allMatch(Character::isDigit);
            if (isNumeric) {
                this.probability = Integer.parseInt(probability);
            } else {
                throw new IllegalStateException(PROBABILITY_STATE_EXCEPTION);
            }
        }
    }
    public WinCode qualifyWin() {
        boolean win = (Math.random() * 100) + 1 <= probability;
        if (win) {
            return WinCode.WIN;
        } else {
            return WinCode.LOSE;
        }
    }
}
