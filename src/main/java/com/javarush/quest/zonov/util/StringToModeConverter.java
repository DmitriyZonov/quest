package com.javarush.quest.zonov.util;

import com.javarush.quest.zonov.repository.QuestMode;
import jakarta.servlet.http.HttpServletRequest;

import static com.javarush.quest.zonov.constants.AttributesConstants.MODE;
import static com.javarush.quest.zonov.constants.ExceptionConstants.MODE_ILLEGAL_STATE;
import static com.javarush.quest.zonov.constants.ExceptionConstants.REQUEST_NOT_NULL;
import static com.javarush.quest.zonov.constants.ModeConstants.BALDHEAD;
import static com.javarush.quest.zonov.constants.ModeConstants.SILENT;
import static com.javarush.quest.zonov.repository.QuestMode.BALDHEAD_MODE;
import static com.javarush.quest.zonov.repository.QuestMode.SILENT_MODE;
import static java.util.Objects.isNull;

public class StringToModeConverter {
    private String mode;

    public StringToModeConverter (HttpServletRequest request) {
        if (isNull(request)) {
            throw new IllegalArgumentException(REQUEST_NOT_NULL);
        } else {
            this.mode = request.getParameter(MODE);
        }
    }
    public QuestMode convert() {
        return switch(mode) {
          case SILENT -> SILENT_MODE;
          case BALDHEAD -> BALDHEAD_MODE;
          default -> throw new IllegalStateException(MODE_ILLEGAL_STATE + mode);
        };
    }
}
