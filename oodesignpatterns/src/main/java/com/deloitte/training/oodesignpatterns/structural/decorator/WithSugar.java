package com.deloitte.training.oodesignpatterns.structural.decorator;

import java.util.List;

public class WithSugar extends BeverageDecorator {

    public WithSugar(Beverage beverage) {
        super(beverage);
    }

    @Override
    public List<Ingredient> getIngredients() {
        List<Ingredient> ingredients = super.getIngredients();
        ingredients.add(Ingredient.SUGAR);
        return ingredients;
    }

}
