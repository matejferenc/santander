package com.mf;

import java.util.Date;

/**
 * Created by matej on 10/28/2016.
 */
public class Client {

    public final Products products;

    public final Date date;

    public final int ncodpers;

    public String sexo;

    public String ind_empleado;

    public String pais_residencia;

    public Integer age;

    public boolean ind_nuevo;

    public Integer antiguedad;

    public String indresi;

    public boolean conyuemp;

    public String cod_prov;

    public String nomprov;

    public boolean ind_actividad_cliente;

    public Integer renta;

    public String segmento;

    public Client(Date date, int ncodpers, Products products) {
        this.date = date;
        this.ncodpers = ncodpers;
        this.products = products;
    }
}
