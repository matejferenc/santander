package com.mf.transition;

import com.mf.*;

import static java.util.stream.Collectors.toMap;

/**
 * Created by matej on 10/28/2016.
 */
public class Transitions extends Strategy {

    public static void main(String[] args) throws Exception {
        new Transitions().execute();
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
        return new TransitionPredictor();
    }

    @Override
    protected void setValidationClients(Predictor predictor) {
        super.setValidationClients(predictor);
    }
}
