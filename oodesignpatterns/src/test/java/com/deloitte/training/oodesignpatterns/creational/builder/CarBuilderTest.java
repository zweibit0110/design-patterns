package com.deloitte.training.oodesignpatterns.creational.builder;

import java.awt.Color;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class CarBuilderTest {

    @Test
    public void buildANormalCar() {
        Car car = new CarBuilder().
                setCarType(CarType.HATCHBACK).
                setColor(Color.GRAY).
                build();

        assertThat(car.getCarType(), is(CarType.HATCHBACK));
        assertThat(car.getColor(), is(Color.GRAY));

        assertThat(car.getWheelsCount(), is(4));
        assertThat(car.getSeatsCount(), is(4));

        assertThat(car.hasPremiumFeatures(), is(false));
    }

    @Test
    public void buildAPremiumCar() {
        Car premiumCar = new CarBuilder().
                setCarType(CarType.SEDAN).
                setColor(Color.BLUE).
                setGpsOption(true).
                setLeatherOption(true).
                setVentilatedSeats(true).
                build();

        assertThat(premiumCar.getCarType(), is(CarType.SEDAN));
        assertThat(premiumCar.getColor(), is(Color.BLUE));
        assertTrue(premiumCar.hasGpsOption());
        assertTrue(premiumCar.hasLeatherOption());
        assertTrue(premiumCar.hasVentilatedSeats());

        assertThat(premiumCar.getWheelsCount(), is(4));
        assertThat(premiumCar.getSeatsCount(), is(4));

        assertThat(premiumCar.hasPremiumFeatures(), is(true));
    }

}
