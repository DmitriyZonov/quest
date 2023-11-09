package com.javarush.quest.zonov.utilTests;

import com.javarush.quest.zonov.util.HitProbabilityMonitor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import static java.util.Objects.isNull;


public class HitProbabilityMonitorTest {

    @Spy
    HitProbabilityMonitor monitor;

    @Test
    public void workingOfProbabilityCalculatorClass() {
        monitor = new HitProbabilityMonitor();
        String probability = monitor.analyzeProbability();
        boolean isNull = isNull(probability);
        Assertions.assertEquals(isNull, false);
    }
}
