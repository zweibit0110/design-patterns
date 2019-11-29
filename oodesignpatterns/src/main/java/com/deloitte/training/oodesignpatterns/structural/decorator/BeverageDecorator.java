package com.deloitte.training.oodesignpatterns.structural.decorator;

import java.util.List;

public class BeverageDecorator implements Beverage {

    private Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public List<Ingredient> getIngredients() {
        return beverage.getIngredients();
    }

}
