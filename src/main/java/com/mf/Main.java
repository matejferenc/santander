package com.mf;

import au.com.bytecode.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by matej on 10/28/2016.
 */
public class Main {

    public static final String TRAIN_PATH = "train_ver2.csv";
    public static final String TEST_PATH = "test_ver2.csv";

    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        new Main().execute();
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) / (double) 1000 + " seconds");
    }

    private void execute() throws Exception {
        File file = new File(this.getClass().getClassLoader().getResource(TRAIN_PATH).getFile());
        CSVReader reader = new CSVReader(new FileReader(file));
        String[] nextLine;
        int total = 0;
        reader.readNext();
        Set<Integer> clients = new HashSet<>();
        Map<Date, Integer> clientsForDate = new HashMap<>();
        Map<Products, Integer> productsCount = new HashMap<>();
        TrainTestSplitter trainTestSplitter = new TrainTestSplitter();
        Map<String, Integer> productCounts = new HashMap<>();
        Map<Integer, Map<String, Integer>> countsOfProductsByAge = new HashMap<>();
        while ((nextLine = reader.readNext()) != null) {
            int ncodpers = Integer.valueOf(nextLine[1].trim());
            Date date = dateFormat.parse(nextLine[0].trim());
            String ageString = nextLine[5].trim();
            int age = ageString.matches("[0-9]+") ? Integer.parseInt(ageString) : -1;
            clientsForDate.put(date, clientsForDate.get(date) == null ? 1 : clientsForDate.get(date) + 1);
            clients.add(ncodpers);
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

            if (productsCount.containsKey(products)) {
                productsCount.put(products, productsCount.get(products) + 1);
            } else {
                productsCount.put(products, 1);
            }

            products.toList().forEach(product -> {
                productCounts.putIfAbsent(product, 0);
                productCounts.put(product, productCounts.get(product) + 1);
            });

            trainTestSplitter.addClient(client);

            Map<String, Integer> productCounts1 = countsOfProductsByAge.get(age);
            if (productCounts1 == null) {
                productCounts1 = new HashMap<>();
                countsOfProductsByAge.put(age, productCounts1);
            }
            Map<String, Integer> finalProductCounts = productCounts1;
            products.toList().forEach(product -> {
                finalProductCounts.putIfAbsent(product, 0);
                finalProductCounts.put(product, finalProductCounts.get(product) + 1);
            });

            total++;
            if (total % 100000 == 0) {
                System.out.println("Processed: " + total);
            }
        }
        System.out.println("Total: " + total);
        System.out.println(clients.size());
        clientsForDate.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(System.out::println);

        System.out.println("Different product compositions: " + productsCount.size());
        System.out.println("Top favourite products");
        productsCount.entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue()).limit(10).forEach(System.out::println);

        System.out.println("Counts of products:");
        productCounts.entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue()).forEach(System.out::println);

        System.out.println("Counts of products by age:");
        countsOfProductsByAge.entrySet().stream().sorted((a, b) -> a.getKey() - b.getKey()).forEach(e -> {
            StringBuilder sb = new StringBuilder("" + e.getKey());
            Products.ALL.forEach(product -> {
                if (e.getValue().containsKey(product)) {
                    sb.append("\t" + e.getValue().get(product));
                } else {
                    sb.append("\t0");
                }
            });
            System.out.println(sb.toString());
        });
    }
}
