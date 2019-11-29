package com.deloitte.training.oodesignpatterns.creational.abstractfactory;

import com.deloitte.training.oodesignpatterns.creational.factorymethod.ShapeFactory;

public class FactoryProducer {

    public static AbstractFactory getFactory(FactoryType factoryType) {
        switch (factoryType) {
            case COLOR_FACTORY:
                return new ColorFactory();
            case SHAPE_FACTORY:
                return new ShapeFactory();
            default:
                throw new IllegalArgumentException(String.format("Don't know how to get %s factory.", factoryType));
        }
    }
    
}
