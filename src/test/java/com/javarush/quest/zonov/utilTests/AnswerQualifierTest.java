package com.javarush.quest.zonov.utilTests;

import com.javarush.quest.zonov.util.AnswerQualifier;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import static com.javarush.quest.zonov.constants.ExceptionConstants.REQUEST_NOT_NULL;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AnswerQualifierTest {
    @Spy
    AnswerQualifier qualifier;

    @Test
    public void creationOfAnswerQualifierWhenRequestIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                qualifier = new AnswerQualifier(null));

        Assertions.assertEquals(REQUEST_NOT_NULL, exception.getMessage());
    }
}
