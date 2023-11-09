package com.javarush.quest.zonov.utilTests;

import com.javarush.quest.zonov.constants.RaceInGenitiveCaseConstants;
import com.javarush.quest.zonov.repository.Race;
import com.javarush.quest.zonov.util.UserRaceInGenitiveCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import static com.javarush.quest.zonov.constants.ExceptionConstants.RACE_NOT_NULL;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserRaceInGenitiveCaseTest {
    @Spy
    UserRaceInGenitiveCase userRaceInGenitiveCase;

    @Test
    public void whenParameterIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                userRaceInGenitiveCase = new UserRaceInGenitiveCase(null));

        Assertions.assertEquals(RACE_NOT_NULL, exception.getMessage());
    }
    @Test
    public void toGenitive(){
        userRaceInGenitiveCase = new UserRaceInGenitiveCase(Race.ELF);

        String genitiveCase = userRaceInGenitiveCase.toGenitive();

        Assertions.assertEquals(genitiveCase, RaceInGenitiveCaseConstants.ELF);
    }
}
