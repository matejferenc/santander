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
        return true;
    }

    @Override
    protected boolean isValidate() {
        return true;
    }

    @Override
    public Predictor createPredictor() {
        return new SubsetIndexPredictor();
    }

}
