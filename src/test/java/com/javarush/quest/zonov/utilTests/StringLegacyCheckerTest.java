package com.javarush.quest.zonov.utilTests;

import com.javarush.quest.zonov.util.StringLegacyChecker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import static com.javarush.quest.zonov.constants.ExceptionConstants.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringLegacyCheckerTest {

    @Spy
    StringLegacyChecker checker;

    @Test
    public void whenParameterIsNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () ->
                checker = new StringLegacyChecker(null));

        Assertions.assertEquals(NOT_NULL, exception.getMessage());
    }
    @Test
    public void whenParameterIsBlank() {
        String parameter = " ";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                checker = new StringLegacyChecker(parameter));

        Assertions.assertEquals(NOT_BLANK, exception.getMessage());
    }
    @Test
    public void whenParameterIsEmpty() {
        String parameter = "";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                checker = new StringLegacyChecker(parameter));

    Assertions.assertEquals(NOT_EMPTY, exception.getMessage());
    }
    @Test
    public void checker() {
        String parameter = "test";
        checker = new StringLegacyChecker("test");
        boolean isChecked = checker.check();

        Assertions.assertEquals(isChecked, true);
    }
}
