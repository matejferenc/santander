package com.mf.subsetIndex;

import com.mf.Predictor;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.mf.Products.*;

/**
 * Created by matej on 10/29/2016.
 */
public class SubsetIndexPredictor extends Predictor {

    private static final int COUNT = 15;

    @Override
    public Map<Integer, List<String>> predict() {
        prepare();
        return null;
//        return testClients.entrySet().stream().collect(Collectors.toMap(
//                e -> e.getKey(),
//                e -> random(COUNT))
//        );
    }

    private void prepare() {

    }

}
