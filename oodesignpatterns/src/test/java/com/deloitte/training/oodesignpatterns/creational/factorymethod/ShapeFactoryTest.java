package com.deloitte.training.oodesignpatterns.creational.factorymethod;

import static org.junit.Assert.*;
import org.junit.Test;

public class ShapeFactoryTest {

    private ShapeFactory shapeFactory = new ShapeFactory();

    @Test
    public void createCircle() {
        Shape circle = shapeFactory.getShape(ShapeType.CIRCLE);
        assertTrue(circle instanceof Shape);
    }

    @Test
    public void createRecatngle() {
        Shape rectangle = shapeFactory.getShape(ShapeType.RECTANGLE);
        assertTrue(rectangle instanceof Shape);
    }

    @Test
    public void cannotCreateGenericShape() {
        try {
            Shape generic = shapeFactory.getShape(ShapeType.GENERIC);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

    }
}
