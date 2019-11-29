package com.deloitte.training.oodesignpatterns.creational.abstractfactory;

import com.deloitte.training.oodesignpatterns.creational.factorymethod.Shape;
import com.deloitte.training.oodesignpatterns.creational.factorymethod.ShapeType;

public abstract class AbstractFactory {

    public abstract Color getColor(ColorType colorType);

    public abstract Shape getShape(ShapeType shapeType);
    
}
