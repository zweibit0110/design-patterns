package com.deloitte.training.oodesignpatterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {

    private static final Map<ShapeType, Shape> shapes = new HashMap<>();

    public static Shape getShape(ShapeType type) {
        Shape shape = shapes.get(type);

        if (shape == null) {
            switch (type) {
                case OVAL_FILL:
                    shape = new Oval(true);
                    break;
                case OVAL_NOFILL:
                    shape = new Oval(false);
                    break;
                case LINE:
                    shape = new Line();
                    break;
                case RECTANGLE_FILL:
                    shape = new Rectangle(true);
                    break;
                case RECTANGLE_NOFILL:
                    shape = new Rectangle(false);
                    break;
                default:
                    break;
            }

            shapes.put(type, shape);
        }

        return shape;
    }

    protected static int getShapesCount() {
        return shapes.size();
    }

}
