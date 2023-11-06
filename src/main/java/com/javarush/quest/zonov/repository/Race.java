package com.javarush.quest.zonov.repository;

import com.javarush.quest.zonov.constants.RaceConstants;

public enum Race {
    ELF(RaceConstants.ELF), DWARF(RaceConstants.DWARF), WIZARD(RaceConstants.WIZARD), WARRIOR(RaceConstants.WARRIOR);

    private final String race;

    Race(String race){
        this.race = race;
    }

    public String getNameOfRace() {
        return race;
    }
}
