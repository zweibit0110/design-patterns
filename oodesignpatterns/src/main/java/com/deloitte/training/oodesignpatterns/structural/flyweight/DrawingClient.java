package com.deloitte.training.oodesignpatterns.structural.flyweight;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawingClient extends JFrame {

    private static final long serialVersionUID = -1350200437285282550L;

    private static final int WIDTH = 1300;

    private static final int HEIGHT = 1000;

    private static final Color colors[] = {Color.RED, Color.GREEN, Color.YELLOW, Color.BLUE, Color.ORANGE};

    public DrawingClient() {
        JButton startButton = new JButton("Draw");
        final JPanel panel = new JPanel();

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(startButton, BorderLayout.SOUTH);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        startButton.addActionListener(
                (ActionEvent event) -> {
                    Graphics g = panel.getGraphics();
                    for (int i = 0; i < 500; ++i) {
                        Shape shape = ShapeFactory.getShape(getRandomShape());
                        shape.draw(g, getRandomX(), getRandomY(), getRandomWidth(), getRandomHeight(), getRandomColor());
                    }
                });
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

    public static void main(String[] args) {
        new DrawingClient();
    }
    
}
