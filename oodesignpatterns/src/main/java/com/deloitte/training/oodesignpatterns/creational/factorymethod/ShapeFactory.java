package com.deloitte.training.oodesignpatterns.creational.factorymethod;

import com.deloitte.training.oodesignpatterns.creational.abstractfactory.AbstractFactory;
import com.deloitte.training.oodesignpatterns.creational.abstractfactory.Color;
import com.deloitte.training.oodesignpatterns.creational.abstractfactory.ColorType;

public class ShapeFactory extends AbstractFactory {

    // factory method
    @Override
    public Shape getShape(ShapeType shapeType) {
        switch (shapeType) {
            case CIRCLE:
                return new Circle();
            case RECTANGLE:
                return new Rectangle();
            case SQUARE:
                return new Square();
            default:
                throw new IllegalArgumentException(String.format("Don't know how to build a %s shape.", shapeType));
        }
    }

    @Override
    public Color getColor(ColorType colorType) {
        throw new UnsupportedOperationException("Operation is not supported.");
    }

}
