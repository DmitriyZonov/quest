package com.javarush.quest.zonov.util;

import com.javarush.quest.zonov.repository.Location;
import com.javarush.quest.zonov.services.*;

import static com.javarush.quest.zonov.constants.ExceptionConstants.LOCATION_NOT_NULL;
import static java.util.Objects.isNull;

public class LocationToFunction {

    private Location location;

    public LocationToFunction(Location location) {
        if (isNull(location)) {
            throw new IllegalArgumentException(LOCATION_NOT_NULL);
        } else {
            this.location = location;
        }
    }
    public Function convert() {
        return switch (location) {
            case TAVERN -> new TavernAction();
            case OUTSIDE_TAVERN -> new OutsideTavernAction();
            case CAVE -> new CaveAction();
            case CASTLE -> new CastleAction();
        };
    }
}
