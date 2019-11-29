package com.deloitte.training.oodesignpatterns.structural.decorator;

import java.util.List;

public class WithLemon extends BeverageDecorator {

    public WithLemon(Beverage beverage) {
        super(beverage);
    }

    @Override
    public List<Ingredient> getIngredients() {
        List<Ingredient> ingredients = super.getIngredients();
        ingredients.add(Ingredient.LEMON);
        return ingredients;
    }

}
