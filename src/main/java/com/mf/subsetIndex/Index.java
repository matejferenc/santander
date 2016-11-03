package com.mf.subsetIndex;

import com.mf.Client;
import com.mf.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matej on 10/30/2016.
 */
public class Index {

    boolean sexoPresent;

    boolean ind_empleadoPresent;

    boolean pais_residenciaPresent;

    boolean agePresent;

    boolean ind_nuevoPresent;

    boolean antiguedadPresent;

    boolean conyuempPresent;

    boolean cod_provPresent;

    boolean rentaPresent;

    boolean segmentoPresent;

    public Index(boolean sexoPresent, boolean ind_empleadoPresent, boolean pais_residenciaPresent, boolean agePresent, boolean ind_nuevoPresent, boolean antiguedadPresent, boolean conyuempPresent, boolean cod_provPresent, boolean rentaPresent, boolean segmentoPresent) {
        this.sexoPresent = sexoPresent;
        this.ind_empleadoPresent = ind_empleadoPresent;
        this.pais_residenciaPresent = pais_residenciaPresent;
        this.agePresent = agePresent;
        this.ind_nuevoPresent = ind_nuevoPresent;
        this.antiguedadPresent = antiguedadPresent;
        this.conyuempPresent = conyuempPresent;
        this.cod_provPresent = cod_provPresent;
        this.rentaPresent = rentaPresent;
        this.segmentoPresent = segmentoPresent;
    }

    public Index() {
    }

    String createHash(Client client) {
        List<String> parts = new ArrayList<>();
        if (sexoPresent) parts.add(client.sexo);
        if (ind_empleadoPresent) parts.add(client.ind_empleado);
        if (pais_residenciaPresent) parts.add(client.pais_residencia);
        if (agePresent) parts.add("" + client.age);
        if (ind_nuevoPresent) parts.add(client.ind_nuevo ? "1" : "0");
        if (antiguedadPresent) parts.add("" + client.antiguedad);
        if (conyuempPresent) parts.add(client.conyuemp ? "1" : "0");
        if (cod_provPresent) parts.add(client.cod_prov);
        if (rentaPresent) parts.add("" + client.renta);
        if (segmentoPresent) parts.add(client.segmento);
        return String.join(",", parts);
    }

    @Override
    public String toString() {
        return "Index{" +
                "sexoPresent=" + sexoPresent +
                ", ind_empleadoPresent=" + ind_empleadoPresent +
                ", pais_residenciaPresent=" + pais_residenciaPresent +
                ", agePresent=" + agePresent +
                ", ind_nuevoPresent=" + ind_nuevoPresent +
                ", antiguedadPresent=" + antiguedadPresent +
                ", conyuempPresent=" + conyuempPresent +
                ", cod_provPresent=" + cod_provPresent +
                ", rentaPresent=" + rentaPresent +
                ", segmentoPresent=" + segmentoPresent +
                '}';
    }

    static Index random() {
        Index index = new Index();
        index.sexoPresent = Utils.randomBoolean();
        index.ind_empleadoPresent = Utils.randomBoolean();
        index.pais_residenciaPresent = Utils.randomBoolean();
        index.agePresent = Utils.randomBoolean();
        index.ind_nuevoPresent = Utils.randomBoolean();
        index.antiguedadPresent = Utils.randomBoolean();
        index.conyuempPresent = Utils.randomBoolean();
        index.cod_provPresent = Utils.randomBoolean();
        index.rentaPresent = Utils.randomBoolean();
        index.segmentoPresent = Utils.randomBoolean();
        return index;
    }
}
