package com.javarush.quest.zonov.util;

import static com.javarush.quest.zonov.constants.ExceptionConstants.*;
import static java.util.Objects.isNull;

public class StringLegacyChecker {
    private String parameter;

    public StringLegacyChecker(String parameter) {
        if (isNull(parameter)){
            throw new NullPointerException(NOT_NULL);
        } else if (parameter.isEmpty()) {
            throw new IllegalArgumentException(NOT_EMPTY);
        } else if (parameter.isBlank()) {
            throw new IllegalArgumentException(NOT_BLANK);
        } else {
            this.parameter = parameter;
        }
    }
    public boolean check() {
        return !isNull(parameter);
    }
}
