package com.deloitte.training.oodesignpatterns.structural.adapter;

public class UKElectricalSocket {
    
    public String plugIn(UKPlug ukPlug) {
        int voltage = ukPlug.provideUKElectricity().getValue();
        
        return String.format("UK Plug + UK electrical socket @ %d volts.", voltage);
    }
    
}
