package com.javarush.quest.zonov.util;

import com.javarush.quest.zonov.entity.Race;
import com.javarush.quest.zonov.entity.Race.*;

import static com.javarush.quest.zonov.entity.Race.*;

public class StringToRaceConverter {
    private String raceName;
    public StringToRaceConverter(String raceName) {
        this.raceName = raceName;
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
