package com.javarush.quest.zonov.util;

import com.javarush.quest.zonov.repository.Location;
import jakarta.servlet.http.HttpServletRequest;

import static com.javarush.quest.zonov.constants.AttributesConstants.LOCATION;
import static com.javarush.quest.zonov.constants.ExceptionConstants.LOCATION_ILLEGAL_STATE;
import static com.javarush.quest.zonov.constants.ExceptionConstants.REQUEST_NOT_NULL;
import static com.javarush.quest.zonov.constants.LocationConstants.*;
import static java.util.Objects.isNull;

public class StringToLocationConverter {

    private String location;

    public StringToLocationConverter(HttpServletRequest request) {
        if (isNull(request)) {
            throw new IllegalArgumentException(REQUEST_NOT_NULL);
        } else {
            this.location = request.getParameter(LOCATION);
        }
    }

    public Location convert() {
        return switch(location) {
            case TAVERN -> Location.TAVERN;
            case OUTSIDE_TAVERN -> Location.OUTSIDE_TAVERN;
            case CAVE -> Location.CAVE;
            case CASTLE -> Location.CASTLE;
            default -> throw new IllegalStateException(LOCATION_ILLEGAL_STATE + location);
        };
    }
}
