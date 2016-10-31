package com.mf.subsetIndex;

import com.mf.Client;

/**
 * Created by matej on 10/30/2016.
 */
public class Index {

    public static String createHash(Client client) {
        return "" + client.age + "," + client.renta + "," + client.cod_prov;
    }
}
