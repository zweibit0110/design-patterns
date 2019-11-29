package com.deloitte.training.oodesignpatterns.structural.adapter;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

public class PlugAdapterTest {

    @Test
    public void matchEuropePlugWithEuropeSocket() {
        EuropePlug plug = new EuropePlugImpl();
        
        EuropeElectricalSocket socket = new EuropeElectricalSocket();
        
        String pluggedIn = socket.plugIn(plug);
        
        assertThat(pluggedIn, containsString("240 volts"));
    }
    
    @Test
    public void matchUKPlugWithUKSocket() {
        UKPlug plug = new UKPlugImpl();
        
        UKElectricalSocket socket = new UKElectricalSocket();
        
        String pluggedIn = socket.plugIn(plug);
        
        assertThat(pluggedIn, containsString("240 volts"));
    }
    
    @Test
    public void matchUSAPlugWithUSASocket() {
        USAPlug plug = new USAPlugImpl();
        
        USAElectricalSocket socket = new USAElectricalSocket();
        
        String pluggedIn = socket.plugIn(plug);
        
        assertThat(pluggedIn, containsString("120 volts"));
    }
    
    @Test
    public void adaptUKPlugToEuropeSocket() {
        UKPlug plug = new UKPlugImpl();
        
        UKToEuropePlugAdapter adapter = new UKToEuropePlugAdapter(plug);
        
        EuropeElectricalSocket socket = new EuropeElectricalSocket();
        
        String pluggedIn = socket.plugIn(adapter);
        
        assertThat(pluggedIn, containsString("240 volts"));
    }
    
    @Test
    public void adaptUSAPlugToEuropeSocket() {        
        USAToEuropePlugAdapter adapter = new USAToEuropePlugAdapter();
        
        EuropeElectricalSocket socket = new EuropeElectricalSocket();
        
        String pluggedIn = socket.plugIn(adapter);
        
        assertThat(pluggedIn, containsString("240 volts"));
    }
    
}
