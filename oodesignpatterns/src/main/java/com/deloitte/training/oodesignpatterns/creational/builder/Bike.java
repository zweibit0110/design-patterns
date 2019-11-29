package com.deloitte.training.oodesignpatterns.creational.builder;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public final class Bike {
    
    private final Color color;

    private final BikeType bikeType;

    private final int wheelCount;
    
    private final int speedCount;
    
    private final boolean premiumSaddle;
    
    private final List<String> accesories;

    public static class BikeBuilder implements Builder<Bike> {
        
        private Color color;

        private BikeType bikeType;

        private int wheelCount = 2; // default 2 wheels on bike
        
        private int speedCount = 27; // default speed count
        
        private boolean premiumSaddle;
        
        private List<String> accesories;
        
        public BikeBuilder color(Color value) {
            color = value;
            return this;
        }
        
        public BikeBuilder bikeType(BikeType value) {
            bikeType = value;
            return this;
        }
        
        public BikeBuilder wheelCount(int value) {
            wheelCount = value;
            return this;
        }
        
        public BikeBuilder speedCount(int value) {
            speedCount = value;
            return this;
        }
        
        public BikeBuilder premiumSaddle(boolean value) {
            premiumSaddle = value;
            return this;
        }
        
        public BikeBuilder accesories(List<String> value) {
            accesories = value;
            return this;
        }
        
        @Override
        public Bike build() {
            return new Bike(this);
        }
    }
    
    private Bike(BikeBuilder bikeBuilder) {
        this.color = bikeBuilder.color;
        this.bikeType = bikeBuilder.bikeType;
        this.wheelCount = bikeBuilder.wheelCount;
        this.speedCount = bikeBuilder.speedCount;
        this.premiumSaddle = bikeBuilder.premiumSaddle;
        this.accesories = bikeBuilder.accesories != null ? 
                new ArrayList<>(bikeBuilder.accesories) : 
                null;
    }

    public Color getColor() {
        return color;
    }

    public BikeType getBikeType() {
        return bikeType;
    }

    public int getWheelCount() {
        return wheelCount;
    }

    public int getSpeedCount() {
        return speedCount;
    }

    public boolean hasPremiumSaddle() {
        return premiumSaddle;
    }
    
    public List<String> getAccesories() {
        return new ArrayList<>(accesories);
    }
    
}
