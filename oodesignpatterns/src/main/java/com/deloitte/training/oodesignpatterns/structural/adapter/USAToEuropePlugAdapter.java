package com.deloitte.training.oodesignpatterns.structural.adapter;

public class USAToEuropePlugAdapter extends USAPlugImpl implements EuropePlug {

    @Override
    public Voltage provideEuropeElectricity() {
        System.out.println("Different voltage between USA and Europe, needs conversion.");
        return convertVoltage(this.provideUSAElectricity());
    }

    private Voltage convertVoltage(Voltage usaVoltage) {
        return new Voltage(usaVoltage.getValue() * 2);
    }
    
}
