package com.deloitte.training.oodesignpatterns.creational.abstractfactory;

import com.deloitte.training.oodesignpatterns.creational.factorymethod.Circle;
import com.deloitte.training.oodesignpatterns.creational.factorymethod.Shape;
import com.deloitte.training.oodesignpatterns.creational.factorymethod.ShapeFactory;
import com.deloitte.training.oodesignpatterns.creational.factorymethod.ShapeType;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import org.junit.Test;
import static org.junit.Assert.fail;

public class FactoriesTest {

    @Test
    public void createCircleShape() {
        AbstractFactory factory = FactoryProducer.getFactory(FactoryType.SHAPE_FACTORY);

        assertThat(factory, instanceOf(ShapeFactory.class));

        Shape shape = factory.getShape(ShapeType.CIRCLE);

        assertThat(shape, instanceOf(Circle.class));
    }

    @Test
    public void createRedColor() {
        AbstractFactory factory = FactoryProducer.getFactory(FactoryType.COLOR_FACTORY);

        assertThat(factory, instanceOf(ColorFactory.class));

        Color color = factory.getColor(ColorType.RED);

        assertThat(color, instanceOf(Red.class));
    }

    @Test
    public void cannotCreateUndefinedFactory() {
        try {
            FactoryProducer.getFactory(FactoryType.UNDEFINED);
        } catch (IllegalArgumentException iae) {
            fail(iae.getMessage());
        }
    }

    @Test
    public void wrongCombinationOfFactoryAndProduct() {
        AbstractFactory factory = FactoryProducer.getFactory(FactoryType.COLOR_FACTORY);

        assertThat(factory, instanceOf(ColorFactory.class));

        try {
            factory.getShape(ShapeType.SQUARE);
        } catch (UnsupportedOperationException uoe) {
            fail(uoe.getMessage());
        }
    }

}
