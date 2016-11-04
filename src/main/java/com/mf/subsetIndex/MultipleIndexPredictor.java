package com.mf.subsetIndex;

import com.mf.Client;
import com.mf.Predictor;
import com.mf.Products;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

/**
 * Created by matej on 10/29/2016.
 */
public class MultipleIndexPredictor extends Predictor {

    private Set<Index> indexes = new HashSet<>();
    private Map<Index, Map<String, Map<String, Integer>>> countsForAllIndexes;

    public MultipleIndexPredictor() {
        indexes.add(new Index(true, true, true, true, false, false, false, false, false, true, false, false));
        //indexes.add(new Index(true, false, true, true, false, false, false, false, false, false, false, false));
//        indexes.add(new Index(true, false, true, true, false, false, false, false, false, true, false, false));
        indexes.add(new Index(true, false, true, true, false, false, false, false, false, true, false, true));
        indexes.add(new Index(true, false, true, true, false, false, false, false, false, true, true, false));
        indexes.add(new Index(true, false, true, true, false, true, false, false, false, true, false, false));
        indexes.add(new Index(true, true, true, true, false, false, false, false, false, true, false, false));
        indexes.add(new Index(true, false, true, true, false, false, true, false, false, true, false, false));
    }

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
        Map<String, Integer> countsOfProducts = new HashMap<>();
        indexes.forEach(index -> {
            Map<String, Map<String, Integer>> countsForIndex = countsForAllIndexes.get(index);
            Map<String, Integer> productCountsForHash = countsForIndex.get(index.createHash(client));
            if (productCountsForHash != null) {
                productCountsForHash.forEach((product, count) -> {
                    countsOfProducts.put(product, countsOfProducts.getOrDefault(product, 0) + count);
                });
            }
        });
        List<String> mostCommonProducts = countsOfProducts.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .map(e -> e.getKey())
                .collect(Collectors.toList());
        if (mostCommonProducts == null || mostCommonProducts.isEmpty()) {
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
        countsForAllIndexes = new HashMap<>();
        indexes.forEach(index -> {
            Map<String, Map<String, Integer>> countsByIndex = new HashMap<>();
            Map<Integer, Client> previousMonthClients = new HashMap<>();
            trainClients.forEach(client -> {
                String hash = index.createHash(client);
                countsByIndex.putIfAbsent(hash, new HashMap<>());

                Client previousMonthClient = previousMonthClients.get(client.ncodpers);
                List<String> previousMonthProducts;
                if (previousMonthClient != null) {
                    previousMonthProducts = previousMonthClient.products.toList();
                } else {
                    previousMonthProducts = emptyList();
                }
                List<String> currentMonthProducts = client.products.toList();
                currentMonthProducts.removeAll(previousMonthProducts);
                currentMonthProducts.forEach(product -> {
                    Map<String, Integer> productCountsForHash = countsByIndex.get(hash);
                    productCountsForHash.putIfAbsent(product, 0);
                    productCountsForHash.put(product, productCountsForHash.get(product) + 1);
                });
                previousMonthClients.put(client.ncodpers, client);
            });
            countsForAllIndexes.put(index, countsByIndex);
        });
    }

}
