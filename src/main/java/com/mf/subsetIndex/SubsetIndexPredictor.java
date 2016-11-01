package com.mf.subsetIndex;

import com.mf.Client;
import com.mf.Predictor;
import com.mf.Products;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.mf.Products.*;

/**
 * Created by matej on 10/29/2016.
 */
public class SubsetIndexPredictor extends Predictor {

    Map<String, List<String>> productsByIndexSorted = new HashMap<>();

    @Override
    public Map<Integer, List<String>> predict() {
        prepare();
        return testClients.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        e -> e.getKey(),
                        e -> predict(e.getValue()))
                );
    }

    private List<String> predict(Client client) {
        List<String> mostCommonProducts = productsByIndexSorted.get(Index.createHash(client));
        if (mostCommonProducts == null) {
            return Products.MOST_COMMON_PRODUCTS;
        } else {
            List<String> result = mostCommonProducts.stream().limit(7).collect(Collectors.toList());
            Products.MOST_COMMON_PRODUCTS.forEach(product -> {
                if(!result.contains(product)) result.add(product);
            });
            return result;
        }
    }

    private void prepare() {
        Map<String, Map<String, Integer>> countsByIndex = new HashMap<>();
        trainClients.forEach(client -> {
            String hash = Index.createHash(client);
            countsByIndex.putIfAbsent(hash, new HashMap<>());
            Products.ALL.forEach(product -> {
                Map<String, Integer> productCountsForHash = countsByIndex.get(hash);
                productCountsForHash.putIfAbsent(product, 0);
                productCountsForHash.put(product, productCountsForHash.get(product) + 1);
            });
        });
        productsByIndexSorted = countsByIndex.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        e -> e.getKey(),
                        e -> e.getValue().entrySet()
                                .stream()
                                .sorted((a, b) -> b.getValue() - a.getValue())
                                .map(e1 -> e1.getKey())
                                .collect(Collectors.toList())
                ));
    }

}
