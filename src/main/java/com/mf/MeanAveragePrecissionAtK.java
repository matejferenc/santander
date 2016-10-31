package com.mf;

import java.util.List;
import java.util.Map;

/**
 * Created by matej on 10/30/2016.
 */
public class MeanAveragePrecissionAtK {

    public static final int SEVEN = 7;

    public double evaluate(Map<Integer, List<String>> predicted, Map<Integer, List<String>> correct, int k) {
        if (predicted.size() != correct.size()) {
            throw new IllegalArgumentException();
        }
        double totalAveragePrecisionAtK = predicted.keySet()
                .stream()
                .map(i -> averagePrecisionAtK(predicted.get(i), correct.get(i), k))
                .reduce(Double::sum)
                .orElse(0.0);
        return totalAveragePrecisionAtK / predicted.size();
    }

    private double averagePrecisionAtK(List<String> predicted, List<String> correct, int k) {
        int relevant = Math.min(correct.size(), k);
        if (relevant == 0) {
            return 0;
        }
        int maximumPredicted = Math.min(predicted.size(), k);
        int guessed = 0;
        double totalPrecision = 0;
        for (int i = 0; i < maximumPredicted; i++) {
            if (correct.contains(predicted.get(i))) {
                guessed++;
                totalPrecision += precisionAtK(guessed, i);
            }
        }
        return totalPrecision / relevant;
    }

    private double precisionAtK(int guessed, int k) {
        return guessed / (double) (k + 1);
    }

}
