package com.deloitte.training.oodesignpatterns.structural.decorator;

import java.util.List;
import java.util.stream.Collectors;

public interface Beverage {

    List<Ingredient> getIngredients();

    static void prepareBeverage(List<Ingredient> ingredients) {
        System.out.println(
                String.format("Cost of: %s is %d.\n",
                        getListOfIngredients(ingredients),
                        getTotalPrice(ingredients)));
    }

    static int getTotalPrice(List<Ingredient> ingredients) {
        return ingredients.
                stream().
                mapToInt(Ingredient::getPrice).
                sum();
    }

    static String getListOfIngredients(List<Ingredient> ingredients) {
        return ingredients.
                stream().
                map(Ingredient::getName).
                collect(Collectors.joining("+"));
    }

}
