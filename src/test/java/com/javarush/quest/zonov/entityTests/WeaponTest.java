package com.javarush.quest.zonov.entityTests;

import com.javarush.quest.zonov.constants.RaceConstantsRussian;
import com.javarush.quest.zonov.constants.WeaponConstants;
import com.javarush.quest.zonov.repository.Race;
import com.javarush.quest.zonov.repository.Weapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

public class WeaponTest {
    @Spy
    Weapon weapon;

    @Test
    public void creationOfRace() {
        weapon = Weapon.STAFF;
        String weaponName = weapon.getNameOfWeapon();

        Assertions.assertEquals(weaponName, WeaponConstants.STAFF);
    }
}
