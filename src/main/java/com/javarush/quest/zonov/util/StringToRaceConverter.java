package com.javarush.quest.zonov.util;

import com.javarush.quest.zonov.repository.Race;
import jakarta.servlet.http.HttpServletRequest;

import static com.javarush.quest.zonov.repository.Race.*;

public class StringToRaceConverter {
    private String raceName;
    public StringToRaceConverter(HttpServletRequest request) {
        this.raceName = request.getParameter("userRace");
    }
    public Race convert() {
        return switch (raceName) {
            case "elf" -> ELF;
            case "dwarf" -> DWARF;
            case "wizard" -> WIZARD;
            case "warrior" -> WARRIOR;
            default -> null;
        };
    }
}
