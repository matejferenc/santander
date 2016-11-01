package com.mf;

import java.util.Date;

/**
 * Created by matej on 10/28/2016.
 */
public class Client {

    public final Products products;

    public final Date date;

    public final int ncodpers;

    public String ind_empleado;

    public StringBuilder pais_residencia;

    public String sexo;

    public int age;

    public String ind_nuevo;

    public int antiguedad;

    public String conyuemp;

    public String cod_prov;

    public int renta;

    public String segmento;

    public String ind_empleado;

    public String pais_residencia;

    public Integer age;

    public boolean ind_nuevo;

    public Integer antiguedad;

    public boolean conyuemp;

    public String cod_prov;

    public Integer renta;

    public String segmento;

    public Client(Date date, int ncodpers, Products products) {
        this.date = date;
        this.ncodpers = ncodpers;
        this.products = products;
    }
}
