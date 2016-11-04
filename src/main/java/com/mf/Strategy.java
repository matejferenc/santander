package com.mf;

import au.com.bytecode.opencsv.CSVReader;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by matej on 10/29/2016.
 */
public abstract class Strategy {

    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    Set<Client> testClients = new HashSet<>();
    protected Set<Client> trainClients = new HashSet<>();
    protected Set<Client> validationClients = new HashSet<>();

    private void generateOutput(Map<Integer, List<String>> result) throws Exception {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt"), "utf-8"))) {
            writer.write("ncodpers,added_products\r\n");
            result.entrySet().stream().forEach(e -> {
                try {
                    writer.write(e.getKey() + "," + String.join(" ", e.getValue()) + "\r\n");
                } catch (IOException e1) {
                    throw new RuntimeException(e1);
                }
            });
        }
    }

    private void predict() throws Exception {
        readTest();
        Predictor predictor = createPredictor();
        predictor.addTrainClients(trainClients);
        predictor.addTrainClients(validationClients);
        predictor.setTrainClientsInLastMonth(Utils.clientsSetToMapByClientId(validationClients));
        predictor.addTestClients(testClients);
        generateOutput(predictor.predict());
    }

    protected double validate() throws Exception {
        Predictor predictor = createPredictor();
        setValidationClients(predictor);
        assertClientsAre(predictor.testClients, TrainTestSplitter.may2016);
        Map<Integer, Client> aprilClients = getAprilClientsAsMap(predictor.trainClients);
        predictor.setTrainClientsInLastMonth(aprilClients);
        Map<Integer, List<String>> predicted = predictor.predict();
//        generateOutput(predicted);
        assertClientsAre(aprilClients, TrainTestSplitter.april2016);
        Map<Integer, List<String>> correct = getCorrectProducts(aprilClients, predictor.testClients);
        double map7 = new MeanAveragePrecissionAtK().evaluate(predicted, correct, MeanAveragePrecissionAtK.SEVEN);
        System.out.println("Mean average precision @ 7: " + map7);
        return map7;
    }

    private void assertClientsAre(Map<Integer, Client> clients, Date date) {
        clients.values().stream().forEach(client -> {if (!client.date.equals(date)) throw new IllegalArgumentException();});
    }

    private Map<Integer, Client> getAprilClientsAsMap(Set<Client> clients) {
        return clients
                .stream()
                .filter(e -> e.date.equals(TrainTestSplitter.april2016))
                .collect(Collectors.toMap(
                        e -> e.ncodpers,
                        e -> e
                ));
    }

    protected void setValidationClients(Predictor predictor) {
        predictor.addTrainClients(trainClients);
        predictor.addTestClients(validationClients);
    }

    private Map<Integer, List<String>> getCorrectProducts(Map<Integer, Client> trainClients, Map<Integer, Client> testClients) {
        Map<Integer, List<String>> additionalProducts = testClients.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        e -> e.getKey(),
                        e -> getAdditionalProducts(trainClients, e.getKey(), e.getValue().products)
                ));
        return additionalProducts;
    }

    private List<String> getAdditionalProducts(Map<Integer, Client> trainClients, int ncodpers, Products products) {
        if (trainClients.containsKey(ncodpers)) {
            return products.subtract(trainClients.get(ncodpers).products);
        } else {
            return products.toList();
        }
    }

    public void execute() throws Exception {
        long startTime = System.currentTimeMillis();
        try {
            readTrain();
            if (isValidate()) {
                validate();
            }
            if (isPredict()) {
                predict();
            }
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("Execution time: " + (endTime - startTime) / (double) 1000 + " seconds");
        }
    }

    protected abstract boolean isPredict();

    protected abstract boolean isValidate();

    public abstract Predictor createPredictor();

    protected void readTrain() throws Exception {
        File file = new File(this.getClass().getClassLoader().getResource(Main.TRAIN_PATH).getFile());
        CSVReader reader = new CSVReader(new FileReader(file));
        String[] nextLine;
        int total = 0;
        reader.readNext();
        while ((nextLine = reader.readNext()) != null) {
            int ncodpers = Integer.valueOf(nextLine[1].trim());
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
            Date date = dateFormat.parse(nextLine[0].trim());
            Client client = new Client(date, ncodpers, products);
            setClientAttributes(nextLine, client);
            if (TrainTestSplitter.may2016.equals(date)) {
                validationClients.add(client);
            } else {
                trainClients.add(client);
            }
            total++;
            if (total % 100000 == 0) {
                System.out.println("Training set processed rows: " + total);
            }
        }
        System.out.println("Training set total: " + total);
    }

    private void setClientAttributes(String[] nextLine, Client client) {
        client.ind_empleado = nextLine[2].trim();
        client.pais_residencia = nextLine[3].trim();
        client.age = nextLine[5].trim().matches("[0-9]+") ? Integer.parseInt(nextLine[5].trim()) : null;
        client.ind_nuevo = nextLine[7].trim().equals("1");
        client.antiguedad = nextLine[8].trim().matches("[0-9]+") ? Integer.parseInt(nextLine[8].trim()) : null;
        client.indresi = nextLine[13].trim();
        client.conyuemp = nextLine[15].trim().equals("1");
        client.cod_prov = nextLine[19].trim();
        client.nomprov = nextLine[20].trim();
        client.ind_actividad_cliente = nextLine[21].trim().equals("1");
        client.renta = nextLine[22].trim().matches("[0-9\\.]+") ? (int) (Double.parseDouble(nextLine[22].trim()) / 1000) : null;
        client.segmento = nextLine[23].trim();
    }

    private void readTest() throws Exception {
        File file = new File(this.getClass().getClassLoader().getResource(Main.TEST_PATH).getFile());
        CSVReader reader = new CSVReader(new FileReader(file));
        String[] nextLine;
        int total = 0;
        reader.readNext();
        while ((nextLine = reader.readNext()) != null) {
            int ncodpers = Integer.valueOf(nextLine[1].trim());
            Date date = dateFormat.parse(nextLine[0].trim());
            Client client = new Client(date, ncodpers, null);
            setClientAttributes(nextLine, client);
            testClients.add(client);
            total++;
            if (total % 100000 == 0) {
                System.out.println("Test set processed rows: " + total);
            }
        }
        System.out.println("Test set total: " + total);
    }
}
