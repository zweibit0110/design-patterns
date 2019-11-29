package com.deloitte.training.oodesignpatterns.structural.bridge;

public class Triangle extends Shape {
    
    public Triangle(Color color) {
        super(color);
    }

    @Override
    public String drawWithColor() {
        return String.format("Triangle filled with %s", color.applyColor());
    }
    
}
