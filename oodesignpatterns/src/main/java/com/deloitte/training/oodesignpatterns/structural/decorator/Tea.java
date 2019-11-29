package com.deloitte.training.oodesignpatterns.structural.decorator;

import java.util.ArrayList;
import java.util.List;

public class Tea implements Beverage {

    @Override
    public List<Ingredient> getIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(Ingredient.TEA);
        return ingredients;
    }

}
