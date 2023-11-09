package com.javarush.quest.zonov.entityTests;

import com.javarush.quest.zonov.constants.RaceConstantsRussian;
import com.javarush.quest.zonov.repository.Race;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

public class RaceTest {
    @Spy
    Race race;

    @Test
    public void creationOfRace() {
        race = Race.DWARF;
        String raceName = race.getNameOfRace();

        Assertions.assertEquals(raceName, RaceConstantsRussian.DWARF);
    }
}
