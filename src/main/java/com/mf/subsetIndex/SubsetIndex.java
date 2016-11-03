package com.mf.subsetIndex;

import com.mf.Predictor;
import com.mf.Strategy;

/**
 * Created by matej on 10/29/2016.
 */
public class SubsetIndex extends Strategy {

    public static void main(String[] args) throws Exception {
        new SubsetIndex().execute();
    }

    @Override
    protected boolean isPredict() {
        return false;
    }

    @Override
    protected boolean isValidate() {
        return true;
    }

    @Override
    public Predictor createPredictor() {
        Index index = new Index();
        index.pais_residenciaPresent = true;
        index.sexoPresent = true;
        index.agePresent = true;
        index.ind_nuevoPresent = true;
//        return new SubsetIndexPredictor(index);
        return new MultipleIndexPredictor();
    }

}
