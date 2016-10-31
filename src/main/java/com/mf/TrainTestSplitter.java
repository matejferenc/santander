package com.mf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by matej on 10/28/2016.
 */
public class TrainTestSplitter {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static Date april2016;
    public static Date may2016;
    static {
        try {
            may2016 = dateFormat.parse("2016-05-28");
            april2016 = dateFormat.parse("2016-04-28");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public Set<Client> testClients = new HashSet<>();
    public Set<Client> trainClients = new HashSet<>();

    public TrainTestSplitter() throws ParseException {
    }

    public void addClient(Client client) {
        if (client.date.equals(april2016)) {
            trainClients.add(client);
        } else if (client.date.equals(may2016)) {
            testClients.add(client);
        }
    }
}
