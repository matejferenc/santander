package com.mf;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by matej on 10/30/2016.
 */
public class MeanAveragePrecissionAtKTest {

    @Test
    public void testExample1() {
        MeanAveragePrecissionAtK meanAveragePrecissionAtK = new MeanAveragePrecissionAtK();
        Map<Integer, List<String>> predicted = new HashMap<>();
        predicted.put(1, Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        predicted.put(2, Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
        Map<Integer, List<String>> correct = new HashMap<>();
        correct.put(1, Arrays.asList("1", "3", "6", "9", "10"));
        correct.put(2, Arrays.asList("2", "5", "7"));
        double mapk = meanAveragePrecissionAtK.evaluate(predicted, correct, 10);
        assertEquals(0.53, mapk, 0.01);
    }
}
