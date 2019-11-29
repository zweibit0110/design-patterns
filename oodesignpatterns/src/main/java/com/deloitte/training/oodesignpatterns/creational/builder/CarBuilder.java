package com.deloitte.training.oodesignpatterns.creational.builder;

import java.awt.Color;

public class CarBuilder implements Builder<Car> {
    
    private final Car car;
    
    public CarBuilder() {
        car = new Car();
    }
    
    public CarBuilder setColor(Color color) {
        car.setColor(color);
        return this;
    }
    
    public CarBuilder setWheelsCount(int wheelsCount) {
        car.setWheelsCount(wheelsCount);
        return this;
    }
    
    public CarBuilder setSeatsCount(int seatsCount) {
        car.setSeatsCount(seatsCount);
        return this;
    }
    
    public CarBuilder setCarType(CarType carType) {
        car.setCarType(carType);
        return this;
    }
    
    public CarBuilder setGpsOption(boolean gpsOption) {
        car.setGpsOption(gpsOption);
        return this;
    }
    
    public CarBuilder setLeatherOption(boolean leatherOption) {
        car.setLeatherOption(leatherOption);
        return this;
    }
    
    public CarBuilder setVentilatedSeats(boolean ventilatedSeats) {
        car.setVentilatedSeats(ventilatedSeats);
        return this;
    }
    
    @Override
    public Car build() {
        return car;
    }

}
