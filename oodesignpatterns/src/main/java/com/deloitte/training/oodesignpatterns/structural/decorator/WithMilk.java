package com.deloitte.training.oodesignpatterns.structural.decorator;

import java.util.List;

public class WithMilk extends BeverageDecorator {

    public WithMilk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public List<Ingredient> getIngredients() {
        List<Ingredient> ingredients = super.getIngredients();
        ingredients.add(Ingredient.MILK);
        return ingredients;
    }

}
