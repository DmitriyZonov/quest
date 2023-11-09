package com.javarush.quest.zonov.utilTests;

import com.javarush.quest.zonov.repository.Race;
import com.javarush.quest.zonov.repository.Weapon;
import com.javarush.quest.zonov.util.WeaponToRace;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import static com.javarush.quest.zonov.constants.ExceptionConstants.RACE_NOT_NULL;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WeaponToRaceTest {

    @Spy
    WeaponToRace weaponToRace;

    @Test
    public void whenParameterIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                weaponToRace = new WeaponToRace(null));

        Assertions.assertEquals(RACE_NOT_NULL, exception.getMessage());
    }

    @Test
    public void correlate() {
        Race race  = Race.ELF;

        String weapon = new WeaponToRace(race).correlate();

        Assertions.assertEquals(weapon, Weapon.BOW.getNameOfWeapon());
    }
}
