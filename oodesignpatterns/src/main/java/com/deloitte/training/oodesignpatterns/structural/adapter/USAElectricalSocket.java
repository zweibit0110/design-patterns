package com.deloitte.training.oodesignpatterns.structural.adapter;

public class USAElectricalSocket {

    public String plugIn(USAPlug usaPlug) {
        int voltage = usaPlug.provideUSAElectricity().getValue();
        
        return String.format("USA Plug + USA electrical socket @ %d volts.", voltage);
    }

}
