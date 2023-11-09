package com.javarush.quest.zonov.repository;

import com.javarush.quest.zonov.constants.RaceConstantsRussian;
import com.javarush.quest.zonov.util.StringLegacyChecker;


public enum Race {
    ELF(RaceConstantsRussian.ELF), DWARF(RaceConstantsRussian.DWARF), WIZARD(RaceConstantsRussian.WIZARD), WARRIOR(RaceConstantsRussian.WARRIOR);

    private String race;

    Race(String race){
        if (new StringLegacyChecker(race).check()) {
            this.race = race;
        }
    }
    public String getNameOfRace() {
        return race;
    }
}
