package com.javarush.quest.zonov.util;

import com.javarush.quest.zonov.repository.Location;
import com.javarush.quest.zonov.services.*;

public class LocationToFunction {

    private Location location;

    public LocationToFunction(Location location) {
        this.location = location;
    }
    public Function convert() {
        return switch (location) {
            case TAVERN -> new TavernAction();
            case OUTSIDE_TAVERN -> new OutsideTavernAction();
            case CAVE -> new CaveAction();
            case CASTLE -> new CastleAction();
            default -> new UnsupportedFunction();
        };
    }
}
