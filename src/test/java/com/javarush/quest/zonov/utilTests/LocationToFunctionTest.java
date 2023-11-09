package com.javarush.quest.zonov.utilTests;

import com.javarush.quest.zonov.repository.Location;
import com.javarush.quest.zonov.services.Function;
import com.javarush.quest.zonov.services.TavernAction;
import com.javarush.quest.zonov.util.AnswerQualifier;
import com.javarush.quest.zonov.util.LocationToFunction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import static com.javarush.quest.zonov.constants.ExceptionConstants.LOCATION_NOT_NULL;
import static com.javarush.quest.zonov.constants.ExceptionConstants.REQUEST_NOT_NULL;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LocationToFunctionTest {

    @Spy
    Location location;
    @Spy
    Function function;
    @Spy
    LocationToFunction locationToFunction;

    @Test
    public void locationIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                locationToFunction = new LocationToFunction(null));

        Assertions.assertEquals(LOCATION_NOT_NULL, exception.getMessage());
    }
    @Test
    public void whenLocationIsTavern() {
        location = Location.TAVERN;
        locationToFunction = new LocationToFunction(location);
        function = locationToFunction.convert();
        Class<? extends Function> functionClass = function.getClass();

        Assertions.assertEquals(functionClass, TavernAction.class);
    }
}
