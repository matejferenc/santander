package com.mf.subsetIndex;

import com.mf.Predictor;
import com.mf.Strategy;

import java.util.HashMap;
import java.util.Map;

public class AllCombinationsEvaluator extends Strategy {

    private Index index;

    private Map<Index, Double> indexScores = new HashMap<>();

    public static void main(String[] args) throws Exception {
        new AllCombinationsEvaluator().execute();
    }

    @Override
    protected boolean isPredict() {
        return false;
    }

    @Override
    protected boolean isValidate() {
        return true;
    }

    @Override
    public Predictor createPredictor() {
        return new SubsetIndexPredictor(index);
    }

    @Override
    public void execute() throws Exception {
        long startTime = System.currentTimeMillis();
        try {
            readTrain();
            for (int i = 0; i < 30; i++) {
                long partStartTime = System.currentTimeMillis();
                index = Index.random();
                System.out.println(index);
                double score = validate();
                indexScores.put(index, score);
                long partEndTime = System.currentTimeMillis();
                System.out.println("Part execution time: " + (partEndTime - partStartTime) / (double) 1000 + " seconds");
            }
            indexScores.entrySet()
                    .stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .forEach(e -> {
                System.out.println(e.getKey());
                System.out.println(e.getValue());
            });
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("Execution time: " + (endTime - startTime) / (double) 1000 + " seconds");
        }
    }
}
