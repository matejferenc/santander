package com.mf;

import java.util.Date;

/**
 * Created by matej on 10/28/2016.
 */
public class Client {

    public final Products products;

    public final int ncodpers;

    public final Date date;

    public Client(Date date, int ncodpers, Products products) {
        this.date = date;
        this.ncodpers = ncodpers;
        this.products = products;
    }
}
