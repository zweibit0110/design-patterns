package com.deloitte.training.oodesignpatterns.structural.decorator;

import java.util.List;

public class WithCinnamon extends BeverageDecorator {

    public WithCinnamon(Beverage beverage) {
        super(beverage);
    }

    @Override
    public List<Ingredient> getIngredients() {
        List<Ingredient> ingredients = super.getIngredients();
        ingredients.add(Ingredient.CINNAMON);
        return ingredients;
    }

}
