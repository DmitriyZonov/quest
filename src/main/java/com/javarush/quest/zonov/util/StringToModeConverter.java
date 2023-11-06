package com.javarush.quest.zonov.util;

import com.javarush.quest.zonov.repository.QuestMode;
import jakarta.servlet.http.HttpServletRequest;

import static com.javarush.quest.zonov.repository.QuestMode.BALDHEAD_MODE;
import static com.javarush.quest.zonov.repository.QuestMode.SILENT_MODE;

public class StringToModeConverter {
    private String mode;

    public StringToModeConverter (HttpServletRequest request) {
        this.mode = request.getParameter("mode");
    }
    public QuestMode convert() {
        return switch(mode) {
          case "silent" -> SILENT_MODE;
          case "baldHead" -> BALDHEAD_MODE;
            default -> null;
        };
    }
}
