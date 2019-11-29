package com.deloitte.training.oodesignpatterns.creational.abstractfactory;

import com.deloitte.training.oodesignpatterns.creational.factorymethod.Shape;
import com.deloitte.training.oodesignpatterns.creational.factorymethod.ShapeType;

public class ColorFactory extends AbstractFactory {

    @Override
    public Color getColor(ColorType colorType) {
        switch (colorType) {
            case RED:
                return new Red();
            case GREEN:
                return new Green();
            case BLUE:
                return new Blue();
            default:
                throw new IllegalArgumentException(String.format("Don't know how to get color by type %s.", colorType));
        }
    }

    @Override
    public Shape getShape(ShapeType shapeType) {
        throw new UnsupportedOperationException("Operation is not supported.");
    }
    
}
