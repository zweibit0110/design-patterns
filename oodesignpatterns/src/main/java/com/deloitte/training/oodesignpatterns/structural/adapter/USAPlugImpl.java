package com.deloitte.training.oodesignpatterns.structural.adapter;

public class USAPlugImpl implements USAPlug {

    @Override
    public Voltage provideUSAElectricity() {
        return new Voltage(120);
    }

}
