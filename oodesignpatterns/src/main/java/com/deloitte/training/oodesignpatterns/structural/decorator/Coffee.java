package com.deloitte.training.oodesignpatterns.structural.decorator;

import java.util.ArrayList;
import java.util.List;

public class Coffee implements Beverage {

    @Override
    public List<Ingredient> getIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(Ingredient.COFFEE);
        return ingredients;
    }

}
