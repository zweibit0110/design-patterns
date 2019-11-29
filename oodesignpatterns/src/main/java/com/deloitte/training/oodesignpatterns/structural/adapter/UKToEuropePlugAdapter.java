package com.deloitte.training.oodesignpatterns.structural.adapter;

public class UKToEuropePlugAdapter implements EuropePlug {

    private UKPlug ukPlug;

    public UKToEuropePlugAdapter(UKPlug ukPlug) {
        this.ukPlug = ukPlug;
    }
    
    @Override
    public Voltage provideEuropeElectricity() {
        System.out.println("It's the same voltage between UK and Europe, no need for conversion.");
        
        return ukPlug.provideUKElectricity();
    }
    
}
