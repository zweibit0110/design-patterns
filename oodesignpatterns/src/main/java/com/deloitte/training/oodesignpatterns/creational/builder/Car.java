package com.deloitte.training.oodesignpatterns.creational.builder;

import java.awt.Color;

public class Car {
    
    private Color color;

    private int wheelsCount = 4;// default value: 4 wheels

    private int seatsCount = 4;// default value: 4 seats

    private CarType carType;
    
    private boolean gpsOption;
    
    private boolean leatherOption;
    
    private boolean ventilatedSeats;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    public void setWheelsCount(int wheelsCount) {
        this.wheelsCount = wheelsCount;
    }

    public int getSeatsCount() {
        return seatsCount;
    }

    public void setSeatsCount(int seatsCount) {
        this.seatsCount = seatsCount;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public boolean hasGpsOption() {
        return gpsOption;
    }

    public void setGpsOption(boolean gpsOption) {
        this.gpsOption = gpsOption;
    }

    public boolean hasLeatherOption() {
        return leatherOption;
    }

    public void setLeatherOption(boolean leatherOption) {
        this.leatherOption = leatherOption;
    }

    public boolean hasVentilatedSeats() {
        return ventilatedSeats;
    }

    public void setVentilatedSeats(boolean ventilatedSeats) {
        this.ventilatedSeats = ventilatedSeats;
    }
    
    public boolean hasPremiumFeatures() {
        return hasGpsOption() || hasLeatherOption() || hasVentilatedSeats();
    }

}
