package com.mf.Random;

import com.mf.Client;
import com.mf.Predictor;
import static com.mf.Products.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by matej on 10/29/2016.
 */
public class RandomPredictor extends Predictor {

    private static final int COUNT = 15;

    @Override
    public Map<Integer, List<String>> predict() {
        return testClients.entrySet().stream().collect(Collectors.toMap(
                e -> e.getKey(),
                e -> random(COUNT))
        );
    }

    private List<String> random(int count) {
//        return Products.ALL.subList(0, count);
//        return Arrays.asList(Products.IND_CCO_FIN_ULT1);
        // TODO: 001011011000100000000001
//        return Arrays.asList(IND_CCO_FIN_ULT1, IND_CNO_FIN_ULT1, IND_CTJU_FIN_ULT1, IND_CTOP_FIN_ULT1, IND_CTPP_FIN_ULT1,
//                IND_ECUE_FIN_ULT1, IND_RECIBO_ULT1);
        return Arrays.asList(IND_CCO_FIN_ULT1, IND_CTOP_FIN_ULT1, IND_RECIBO_ULT1, IND_ECUE_FIN_ULT1, IND_CNO_FIN_ULT1,
                IND_RECA_FIN_ULT1, IND_TJCR_FIN_ULT1);
    }
}
