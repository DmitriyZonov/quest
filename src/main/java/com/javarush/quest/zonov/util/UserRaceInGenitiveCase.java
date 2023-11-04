package com.javarush.quest.zonov.util;

import com.javarush.quest.zonov.entity.Race;

public class UserRaceInGenitiveCase {
    private final Race race;
    public UserRaceInGenitiveCase(Race race) {
        this.race = race;
    }
    public String toGenitive() {
        String raceInGenitiveCase;
        switch(race) {
            case WARRIOR -> {
                return raceInGenitiveCase = "воина";
            }
            case ELF -> {
                return raceInGenitiveCase = "эльфа";
            }
            case WIZARD -> {
                return raceInGenitiveCase = "чародея";
            }
            case DWARF -> {
                return raceInGenitiveCase = "гнома";
            }
            default -> {
                return raceInGenitiveCase = "героя";
            }
        }
    }
}
