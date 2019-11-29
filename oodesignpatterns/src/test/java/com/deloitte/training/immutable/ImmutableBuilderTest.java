package com.deloitte.training.immutable;

import com.deloitte.training.oodesignpatterns.creational.builder.Bike;
import com.deloitte.training.oodesignpatterns.creational.builder.BikeType;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class ImmutableBuilderTest {
    
    @Test
    public void bikeDoesntChangeAfterBuild() {
        List<String> accesories = new ArrayList<>();
        accesories.add("strong u-lock");
        accesories.add("front and back lights");
        accesories.add("mudguards");
        
        Bike bike = new Bike.BikeBuilder().
                bikeType(BikeType.ROAD).
                color(Color.LIGHT_GRAY).
                speedCount(18).
                accesories(accesories).
                build();
        
        List<String> accesoriesOfBike = bike.getAccesories();
        
        accesories.add("kick stand");
        
        accesoriesOfBike.add("carriers");        
        
        assertThat(accesories, hasSize(4));
        assertThat(accesoriesOfBike, hasSize(4));
        
        assertNotEquals(accesories, accesoriesOfBike);
        assertNotSame(accesories, accesoriesOfBike);
        
        assertThat(bike.getAccesories(), allOf(
                hasSize(3), 
                is(not(accesories)),
                is(not(accesoriesOfBike)),
                contains("strong u-lock", "front and back lights", "mudguards")));
    }
    
}
