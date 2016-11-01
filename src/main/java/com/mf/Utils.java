package com.mf;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by matej on 10/30/2016.
 */
public class Utils {

    public static Map<Integer, Client> clientsSetToMapByClientId(Set<Client> clients) {
        return clients
                .stream()
                .collect(Collectors.toMap(
                        e -> e.ncodpers,
                        e -> e
                ));
    }

    public static boolean randomBoolean() {
        return Math.random() < 0.5;
    }
}
