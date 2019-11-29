package com.deloitte.training.oodesignpatterns.structural.adapter;

public class UKPlugImpl implements UKPlug {

    @Override
    public Voltage provideUKElectricity() {
        return new Voltage(240);
    }
    
}
