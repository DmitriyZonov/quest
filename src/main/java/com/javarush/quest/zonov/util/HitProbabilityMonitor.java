package com.javarush.quest.zonov.util;

import static com.javarush.quest.zonov.constants.ExceptionConstants.PROBABILITY_ILLEGAL_STATE;
import static com.javarush.quest.zonov.constants.ProbabilityConstants.*;

public class HitProbabilityMonitor {

    private int probability = ProbabilityCalculator.calculate();

    public String analyzeProbability() {
        return switch(probability) {
            case 1 -> TEN_PERCENT;
            case 2 -> TWENTY_FIVE_PERCENT;
            case 3 -> FIFTY_PERCENT;
            case 4 -> SEVENTY_PERCENT;
            case 5 -> NINETY_PERCENT;
            case 6 -> ONE_HUNDRED_PERCENT;
            default -> throw new IllegalStateException(PROBABILITY_ILLEGAL_STATE + probability);
        };
    }
    private static class ProbabilityCalculator {

        public static int calculate(){

            return (int) (Math.random() * 6) + 1;
        }
    }
}
