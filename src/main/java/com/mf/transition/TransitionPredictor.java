package com.mf.transition;

import com.mf.Client;
import com.mf.MeanAveragePrecissionAtK;
import com.mf.Predictor;
import com.mf.Products;

import java.util.*;
import java.util.stream.Collectors;

import static com.mf.Products.*;
import static com.mf.Products.IND_CCO_FIN_ULT1;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

/**
 * Created by matej on 10/30/2016.
 */
public class TransitionPredictor extends Predictor {

    private Map<Products, List<Products>> sortedTransitions;

    private Map<Products, ProductsTransition> allTransitions = new HashMap<>();


    List<String> mostCommonProducts = Arrays.asList(IND_CCO_FIN_ULT1, IND_CTOP_FIN_ULT1, IND_RECIBO_ULT1, IND_ECUE_FIN_ULT1,
            IND_CNO_FIN_ULT1, IND_RECA_FIN_ULT1, IND_TJCR_FIN_ULT1);


    @Override
    public Map<Integer, List<String>> predict() {
        prepare();
        return testClients.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        e -> e.getKey(),
                        e -> predictTransition(e.getKey()))
                );
    }

    private List<String> predictTransition(Integer ncodpers) {
        Client clientFromLastMonth = trainClientsInLastMonth.get(ncodpers);
        Products products = clientFromLastMonth == null ? null : clientFromLastMonth.products;
        List<Products> sortedTransitionedProducts = sortedTransitions.get(products);
        List<String> result = new ArrayList<>();
        if (sortedTransitionedProducts != null) {
            List<String> currentListOfProducts = products.toList();
            for (Products p : sortedTransitionedProducts) {
                List<String> newProductsList = p.toList();
                newProductsList.removeAll(currentListOfProducts);
                newProductsList.removeAll(result);
                result.addAll(newProductsList);
                if (result.size() >= MeanAveragePrecissionAtK.SEVEN) {
                    break;
                }
            }
        }
        //adding most common
        if (result.size() < MeanAveragePrecissionAtK.SEVEN) {
            result.addAll(mostCommonProducts.subList(0, MeanAveragePrecissionAtK.SEVEN - result.size()));
        }
        return result;
    }

    private void prepare() {
        Map<Integer, List<Client>> clientsById = new HashMap<>();
        trainClients.stream().forEach(e -> {
            if (!clientsById.containsKey(e.ncodpers)) {
                clientsById.put(e.ncodpers, new ArrayList<>());
            }
            clientsById.get(e.ncodpers).add(e);
        });
        Map<Integer, List<Client>> clientsByIdSortedByDate = clientsById.entrySet()
                .stream()
                .collect(toMap(
                        e -> e.getKey(),
                        e -> e.getValue()
                                .stream()
                                .sorted((left, right) -> left.date.compareTo(right.date))
                                .collect(toList())
                ));
        clientsByIdSortedByDate.forEach((k, v) -> processHistory(v));
        sortedTransitions = allTransitions.entrySet()
                .stream()
                .collect(toMap(
                        e -> e.getKey(),
                        e -> e.getValue().transitions.entrySet()
                                .stream()
                                .sorted((a, b) -> b.getValue() - a.getValue())
                                .map(e1 -> e1.getKey())
                                .collect(Collectors.toList())));
        return;
    }

    private void processHistory(List<Client> clients) {
        Client previous = null;
        for (Client client : clients) {
            // we must have previous client to have a transition
            if (previous != null) {
                ProductsTransition sourceNode = allTransitions.get(previous.products);
                // if there is not yet a node with the product setup
                if (sourceNode == null) {
                    sourceNode = new ProductsTransition();
                    sourceNode.products = previous.products;
                    allTransitions.put(previous.products, sourceNode);
                }
                // now we are sure there is a node with product setup
                // there is no transition to desired state
                if (!sourceNode.transitions.containsKey(client.products)) {
                    // we try to find existing destination node before creating new one
                    ProductsTransition destinationNode = allTransitions.get(client.products);
                    if (destinationNode == null) {
                        // we make sure the destination node exists
                        destinationNode = new ProductsTransition();
                        destinationNode.products = client.products;
                        allTransitions.put(client.products, destinationNode);
                    }
                    sourceNode.transitions.put(client.products, 0);
                }
                // now there is a transition to next state of products; we add 1
                sourceNode.transitions.put(client.products, sourceNode.transitions.get(client.products) + 1);
            }
            previous = client;
        }
    }
}
