package com.deloitte.training.oodesignpatterns.structural.flyweight;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle implements Shape {

    //intrinsic property
    private boolean fill;

    public Rectangle(boolean fill) {
        this.fill = fill;
        System.out.println("Creating Rectangle object with fill = " + fill);
        //adding time delay
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics g, int x, int y, int width, int height, Color color) {
        g.setColor(color);
        g.drawRect(x, y, width, height);
        if (fill) {
            g.fillRect(x, y, width, height);
        }
    }

}
