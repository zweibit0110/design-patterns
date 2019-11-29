package com.deloitte.training.oodesignpatterns.structural.adapter;

public class EuropeElectricalSocket {

    public String plugIn(EuropePlug europePlug) {
        int voltage = europePlug.provideEuropeElectricity().getValue();
        
        return String.format("Europe Plug + Europe electrical socket @ %d volts.", voltage);
    }
}
