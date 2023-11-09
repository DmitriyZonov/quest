package com.javarush.quest.zonov.entityTests;

import com.javarush.quest.zonov.entity.User;
import com.javarush.quest.zonov.repository.Race;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import static com.javarush.quest.zonov.constants.ExceptionConstants.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    @Spy
    User user;

    @Test
    public void userSingletonRealisation() {
        user = User.getInstance();
        User user1 = User.getInstance();

        boolean userIsSingleton = (user == user1);
        Assertions.assertTrue(userIsSingleton);
    }

    @Test
    public void setNameWhenNull() {
        user = User.getInstance();
        NullPointerException exception = assertThrows(NullPointerException.class, () ->
                user.setName(null));

        Assertions.assertEquals(NOT_NULL, exception.getMessage());

    }
    @Test
    public void setNameWhenEmpty() {
        user = User.getInstance();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                user.setName(""));

        Assertions.assertEquals(NOT_EMPTY, exception.getMessage());

    }
    @Test
    public void setNameWhenBlank() {
        user = User.getInstance();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                user.setName(" "));

        Assertions.assertEquals(NOT_BLANK, exception.getMessage());
    }
    @Test
    public void setRaceWhenNull() {
        user = User.getInstance();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                user.setRace(null));

        Assertions.assertEquals(RACE_NOT_NULL, exception.getMessage());

    }
    @Test
    public void getName() {
        user = User.getInstance();
        String name = "testName";
        user.setName(name);

        String getName = user.getName();

        Assertions.assertSame(name, getName);
    }
    @Test
    public void getRaceVerifyGetNameOfRace() {
        user = User.getInstance();
        Race race = Race.DWARF;
        user.setRace(race);

        String getName = user.getRace().getNameOfRace();

        Assertions.assertEquals(getName, "Гном");
    }
}
