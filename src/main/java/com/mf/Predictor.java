package com.mf;

import com.mf.Client;

import java.util.*;

/**
 * Created by matej on 10/28/2016.
 */
public abstract class Predictor {

    protected final Set<Client> trainClients = new HashSet<>();
    protected final Map<Integer, Client> testClients = new HashMap<>();
    protected Map<Integer, Client> trainClientsInLastMonth;

    public void addTrainClients(Set<Client> trainClients) {
        for (Client client : trainClients) {
            this.trainClients.add(client);
        }
    }

    public void addTestClients(Set<Client> testClients) {
        for (Client client : testClients) {
            if (this.testClients.containsKey(client.ncodpers)) {
                throw new IllegalArgumentException();
            }
            this.testClients.put(client.ncodpers, client);
        }
    }

    public abstract Map<Integer, List<String>> predict();

    public void setTrainClientsInLastMonth(Map<Integer, Client> trainClientsInLastMonth) {
        this.trainClientsInLastMonth = trainClientsInLastMonth;
    }

}
