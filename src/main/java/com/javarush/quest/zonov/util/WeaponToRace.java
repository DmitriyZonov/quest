package com.javarush.quest.zonov.util;

import com.javarush.quest.zonov.repository.Race;
import com.javarush.quest.zonov.repository.Weapon;

public class WeaponToRace {
    private Race race;

    public WeaponToRace(Race race) {
        this.race = race;
    }
    public String correlate() {
        switch(race) {
            case DWARF -> {
                return Weapon.AXE.getNameOfWeapon();
            }
            case ELF -> {
                return Weapon.BOW.getNameOfWeapon();
            }
            case WIZARD -> {
                return Weapon.STAFF.getNameOfWeapon();
            }
            case WARRIOR -> {
                return Weapon.SWORD.getNameOfWeapon();
            }
            default -> {
                return Weapon.STICK.getNameOfWeapon();
            }
        }
    }
}
