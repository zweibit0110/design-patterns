package com.deloitte.training.oodesignpatterns.structural.bridge;

public class Pentagon extends Shape {
    
    public Pentagon(Color color) {
        super(color);
    }

    @Override
    public String drawWithColor() {
        return String.format("Pentagon filled with %s", color.applyColor());
    }
    
}
