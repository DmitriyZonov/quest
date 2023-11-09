package com.javarush.quest.zonov.util;

import com.javarush.quest.zonov.constants.RaceInGenitiveCaseConstants;
import com.javarush.quest.zonov.repository.Race;

import static com.javarush.quest.zonov.constants.ExceptionConstants.RACE_NOT_NULL;
import static java.util.Objects.isNull;

public class UserRaceInGenitiveCase {
    private Race race;
    public UserRaceInGenitiveCase(Race race) {
        if(isNull(race)){
            throw new IllegalArgumentException(RACE_NOT_NULL);
        } else {
            this.race = race;
        }
    }
    public String toGenitive() {
        return switch(race) {
            case WARRIOR -> RaceInGenitiveCaseConstants.WARRIOR;
            case ELF -> RaceInGenitiveCaseConstants.ELF;
            case WIZARD -> RaceInGenitiveCaseConstants.WIZARD;
            case DWARF -> RaceInGenitiveCaseConstants.DWARF;
        };
    }
}
