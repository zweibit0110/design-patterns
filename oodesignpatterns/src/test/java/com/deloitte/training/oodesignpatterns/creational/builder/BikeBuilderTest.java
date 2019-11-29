package com.deloitte.training.oodesignpatterns.creational.builder;

import java.awt.Color;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class BikeBuilderTest {

    @Test
    public void buildABike() {
        Bike bike = new Bike.BikeBuilder().
                bikeType(BikeType.MTB).
                color(Color.ORANGE).
                premiumSaddle(true).
                build();
        
        assertEquals(bike.getBikeType(), BikeType.MTB);
        assertEquals(bike.getColor(), Color.ORANGE);
        assertEquals(bike.getWheelCount(), 2);
        assertEquals(bike.getSpeedCount(), 27);
        assertTrue(bike.hasPremiumSaddle());
    }
    
}
