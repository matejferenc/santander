package com.mf.transition;

import au.com.bytecode.opencsv.CSVReader;
import com.mf.Client;
import com.mf.Main;
import com.mf.Products;

import java.io.File;
import java.io.FileReader;
import java.util.*;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

/**
 * Created by matej on 10/29/2016.
 */
public class ProductsTransition {

    Products products;

    Map<Products, Integer> transitions = new HashMap<>();

    private static Map<Products, ProductsTransition> allTransitions = new HashMap<>();

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        new ProductsTransition().execute();
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) / (double) 1000 + " seconds");
    }

    private void execute() throws Exception {
        File file = new File(this.getClass().getClassLoader().getResource(Main.TRAIN_PATH).getFile());
        CSVReader reader = new CSVReader(new FileReader(file));
        String[] nextLine;
        reader.readNext();
        Map<Integer, List<Client>> clientsById = new HashMap<>();
        int total = 0;
        while ((nextLine = reader.readNext()) != null) {
            int ncodpers = Integer.valueOf(nextLine[1].trim());
            Date date = Main.dateFormat.parse(nextLine[0].trim());
            Products products = new Products(nextLine[24],
                    nextLine[25],
                    nextLine[26],
                    nextLine[27],
                    nextLine[28],
                    nextLine[29],
                    nextLine[30],
                    nextLine[31],
                    nextLine[32],
                    nextLine[33],
                    nextLine[34],
                    nextLine[35],
                    nextLine[36],
                    nextLine[37],
                    nextLine[38],
                    nextLine[39],
                    nextLine[40],
                    nextLine[41],
                    nextLine[42],
                    nextLine[43],
                    nextLine[44],
                    nextLine[45],
                    nextLine[46],
                    nextLine[47]);
            Client client = new Client(date, ncodpers, products);

            if (!clientsById.containsKey(ncodpers)) {
                clientsById.put(ncodpers, new ArrayList<>());
            }
            clientsById.get(ncodpers).add(client);
            total++;
            if (total % 100000 == 0) {
                System.out.println("Processed: " + total);
            }
        }
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

        System.out.println("Total lines: " + total);
        System.out.println("Total clients: " + clientsById.size());
        System.out.println("Total different product compositions (nodes): " + allTransitions.size());
        System.out.println("Total transitions (edges): " + allTransitions.entrySet().parallelStream().map(e -> e.getValue().transitions.size()).reduce(Integer::sum).get());
    }

    public static void processHistory(List<Client> clients) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductsTransition that = (ProductsTransition) o;

        return products.equals(that.products);

    }

    @Override
    public int hashCode() {
        return products.hashCode();
    }
}
