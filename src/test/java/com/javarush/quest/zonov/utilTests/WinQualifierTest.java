package com.javarush.quest.zonov.utilTests;

import com.javarush.quest.zonov.util.WinQualifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import static com.javarush.quest.zonov.constants.ExceptionConstants.REQUEST_NOT_NULL;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WinQualifierTest {
    @Spy
    WinQualifier qualifier;

    @Test
    public void whenParameterIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                qualifier = new WinQualifier(null));

        Assertions.assertEquals(REQUEST_NOT_NULL, exception.getMessage());
    }
}
