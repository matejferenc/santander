package com.mf.subsetIndex;

import com.mf.Utils;

import java.util.HashSet;
import java.util.Set;

public class EvolutionAlgorithm {

    private Set<Index> generateRandomPopulation(int size) {
        Set<Index> population = new HashSet<>();
        for (int i = 0; i < size; i++) {
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
            population.add(index);
        }
        return population;
    }
}
