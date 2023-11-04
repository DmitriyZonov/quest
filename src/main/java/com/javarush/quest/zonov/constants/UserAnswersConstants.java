package com.javarush.quest.zonov.constants;

import java.util.HashSet;
import java.util.Set;

public class UserAnswersConstants {
    public static final String NOT_YOUR_BUSINESS = "Не твоё дело, пёс!";
    public static final String I_STARVING_FOR_ADVENTURES = "Меня всегда тянула жажда приключений...";
    public static final String GIVE_YOUR_WORK = "Давай свою работёнку";
    public static final String I_DONT_LIKE_YOU = "Приключениям я рад, но ты мне не нравишься...";

    public static final Set<String> wrongAnswers = new HashSet<>();
    static {
        wrongAnswers.add(NOT_YOUR_BUSINESS);
        wrongAnswers.add(I_DONT_LIKE_YOU);
    }
    public static final Set<String> rightAnswers = new HashSet<>();
    static {
        rightAnswers.add(I_STARVING_FOR_ADVENTURES);
        rightAnswers.add(GIVE_YOUR_WORK);
    }
}
