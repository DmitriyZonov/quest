package com.javarush.quest.zonov.util;

import com.javarush.quest.zonov.repository.Location;
import jakarta.servlet.http.HttpServletRequest;

public class StringToLocationConverter {

    String location;

    public StringToLocationConverter(HttpServletRequest request) {
        this.location = request.getParameter("location");
    }

    public Location convert() {
        return switch(location) {
            case "tavern" -> Location.TAVERN;
            case "outsideTavern" -> Location.OUTSIDE_TAVERN;
            case "cave" -> Location.CAVE;
            case "castle" ->Location.CASTLE;
            default -> null;
        };
    }
}
