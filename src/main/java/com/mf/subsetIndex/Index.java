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

    boolean ind_actividad_clientePresent;

    boolean rentaPresent;

    boolean segmentoPresent;

    boolean ncodpersPresent;

    boolean nomprovPresent;

    boolean indresiPresent;

    public static class IndexBuilder {

        private boolean sexo;
        private boolean ind_empleado;
        private boolean pais_residencia;
        private boolean age;
        private boolean ind_nuevo;
        private boolean antiguedad;
        private boolean indresi;
        private boolean conyuemp;
        private boolean cod_prov;
        private boolean ind_actividad_cliente;
        private boolean renta;
        private boolean segmento;
        private boolean ncodpers;
        private boolean nomprov;

        public IndexBuilder sexo() {
            sexo = true;
            return this;
        }

        public IndexBuilder ind_empleado() {
            ind_empleado = true;
            return this;
        }

        public IndexBuilder pais_residencia() {
            pais_residencia = true;
            return this;
        }

        public IndexBuilder age() {
            age = true;
            return this;
        }

        public IndexBuilder ind_nuevo() {
            ind_nuevo = true;
            return this;
        }

        public IndexBuilder antiguedad() {
            antiguedad = true;
            return this;
        }

        public IndexBuilder indresi() {
            indresi = true;
            return this;
        }

        public IndexBuilder conyuemp() {
            conyuemp = true;
            return this;
        }

        public IndexBuilder cod_prov() {
            cod_prov = true;
            return this;
        }

        public IndexBuilder ind_actividad_cliente() {
            ind_actividad_cliente = true;
            return this;
        }

        public IndexBuilder renta() {
            renta = true;
            return this;
        }

        public IndexBuilder segmento() {
            segmento = true;
            return this;
        }

        public IndexBuilder ncodpers() {
            ncodpers = true;
            return this;
        }

        public IndexBuilder nomprov() {
            nomprov = true;
            return this;
        }

        public Index build() {
            Index index = new Index();
            index.sexoPresent = sexo;
            index.ind_empleadoPresent = ind_empleado;
            index.pais_residenciaPresent = pais_residencia;
            index.agePresent = age;
            index.ind_nuevoPresent = ind_nuevo;
            index.antiguedadPresent = antiguedad;
            index.conyuempPresent = conyuemp;
            index.cod_provPresent = cod_prov;
            index.rentaPresent = renta;
            index.segmentoPresent = segmento;
            index.ncodpersPresent = ncodpers;
            index.nomprovPresent = nomprov;
            index.indresiPresent = indresi;
            index.ind_actividad_clientePresent = ind_actividad_cliente;
            return index;
        }
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
        if (ncodpersPresent) parts.add(client.ncodpers + "");
        if (nomprovPresent) parts.add(client.nomprov);
        if (indresiPresent) parts.add(client.indresi);
        if (ind_actividad_clientePresent) parts.add(client.ind_actividad_cliente ? "1" : "0");
        return String.join(",", parts);
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
        index.ncodpersPresent = Utils.randomBoolean();
        index.indresiPresent = Utils.randomBoolean();
        index.ind_actividad_clientePresent = Utils.randomBoolean();
        index.nomprovPresent = Utils.randomBoolean();
        return index;
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
                ", ind_actividad_clientePresent=" + ind_actividad_clientePresent +
                ", rentaPresent=" + rentaPresent +
                ", segmentoPresent=" + segmentoPresent +
                ", ncodpersPresent=" + ncodpersPresent +
                ", nomprovPresent=" + nomprovPresent +
                ", indresiPresent=" + indresiPresent +
                '}';
    }
}
