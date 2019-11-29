package com.deloitte.training.oodesignpatterns.structural.flyweight;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class ShapeCreationTest {

    private static final int WIDTH = 1300;

    private static final int HEIGHT = 1000;

    private static final Color colors[] = {Color.RED, Color.GREEN, Color.YELLOW, Color.BLUE, Color.ORANGE};

    @Test
    public void createFewShapesAndReplicateThem() {
        System.setProperty("java.awt.headless", "true");
        
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        
        for (int i = 0; i < 500; ++i) {
            Shape shape = ShapeFactory.getShape(getRandomShape());
            shape.draw(g, getRandomX(), getRandomY(), getRandomWidth(), getRandomHeight(), getRandomColor());
        }

        assertThat(ShapeFactory.getShapesCount(), is(ShapeType.values().length));
    }

    private ShapeType getRandomShape() {
        ShapeType[] shapeTypes = ShapeType.values();
        return shapeTypes[(int) (Math.random() * shapeTypes.length)];
    }

    private int getRandomX() {
        return (int) (Math.random() * WIDTH);
    }

    private int getRandomY() {
        return (int) (Math.random() * HEIGHT);
    }

    private int getRandomWidth() {
        return (int) (Math.random() * (WIDTH / 10));
    }

    private int getRandomHeight() {
        return (int) (Math.random() * (HEIGHT / 10));
    }

    private Color getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }
    
}
