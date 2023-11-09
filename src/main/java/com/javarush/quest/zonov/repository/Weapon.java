package com.javarush.quest.zonov.repository;

import com.javarush.quest.zonov.constants.WeaponConstants;
import com.javarush.quest.zonov.util.StringLegacyChecker;

public enum Weapon {
    SWORD(WeaponConstants.SWORD), STAFF(WeaponConstants.STAFF), AXE(WeaponConstants.AXE), BOW(WeaponConstants.BOW);
    private String weapon;

    Weapon(String weapon){
        if (new StringLegacyChecker(weapon).check()) {
            this.weapon = weapon;
        }
    }
    public String getNameOfWeapon() {
        return weapon;
    }

}
