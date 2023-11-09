package com.javarush.quest.zonov.util;

import com.javarush.quest.zonov.repository.Race;
import com.javarush.quest.zonov.repository.Weapon;

import static com.javarush.quest.zonov.constants.ExceptionConstants.RACE_NOT_NULL;
import static java.util.Objects.isNull;

public class WeaponToRace {
    private Race race;

    public WeaponToRace(Race race) {
        if(isNull(race)){
            throw new IllegalArgumentException(RACE_NOT_NULL);
        } else {
            this.race = race;
        }
    }
    public String correlate() {
        return switch(race) {
            case DWARF -> Weapon.AXE.getNameOfWeapon();
            case ELF -> Weapon.BOW.getNameOfWeapon();
            case WIZARD -> Weapon.STAFF.getNameOfWeapon();
            case WARRIOR -> Weapon.SWORD.getNameOfWeapon();
        };
    }
}
