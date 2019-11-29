package com.deloitte.training.oodesignpatterns.structural.adapter;

public class EuropePlugImpl implements EuropePlug {

    @Override
    public Voltage provideEuropeElectricity() {
        return new Voltage(240);
    }

}
