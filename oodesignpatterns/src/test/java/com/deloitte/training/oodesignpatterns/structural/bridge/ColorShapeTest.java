package com.deloitte.training.oodesignpatterns.structural.bridge;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class ColorShapeTest {

    @Test
    public void drawRedTriangle() {
        Shape redTriangle = new Triangle(new RedColor());
        assertThat(redTriangle.drawWithColor(), containsString("Triangle"));
        assertThat(redTriangle.drawWithColor(), containsString("RED color"));
    }

    @Test
    public void drawGreenPentagon() {
        Shape greenPentagon = new Pentagon(new GreenColor());
        assertThat(greenPentagon.drawWithColor(), allOf(
                containsString("Pentagon"),
                containsString("GREEN color")));
    }

}
