package com.javarush.quest.zonov.util;

import com.javarush.quest.zonov.constants.RaceConstantsEnglish;
import com.javarush.quest.zonov.repository.Race;
import jakarta.servlet.http.HttpServletRequest;

import static com.javarush.quest.zonov.constants.AttributesConstants.USERRACE;
import static com.javarush.quest.zonov.constants.ExceptionConstants.REQUEST_NOT_NULL;
import static com.javarush.quest.zonov.constants.ExceptionConstants.USERRACE_ILLEGAL_STATE;
import static com.javarush.quest.zonov.repository.Race.*;
import static java.util.Objects.isNull;

public class StringToRaceConverter {
    private String raceName;
    public StringToRaceConverter(HttpServletRequest request) {
        if(isNull(request)){
            throw new IllegalArgumentException(REQUEST_NOT_NULL);
        } else {
            this.raceName = request.getParameter(USERRACE);
        }
    }
    public Race convert() {
        return switch (raceName) {
            case RaceConstantsEnglish.ELF -> ELF;
            case RaceConstantsEnglish.DWARF -> DWARF;
            case RaceConstantsEnglish.WIZARD -> WIZARD;
            case RaceConstantsEnglish.WARRIOR -> WARRIOR;
            default -> throw new IllegalStateException(USERRACE_ILLEGAL_STATE + raceName);
        };
    }
}
