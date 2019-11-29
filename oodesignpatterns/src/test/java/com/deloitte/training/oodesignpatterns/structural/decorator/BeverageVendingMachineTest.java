package com.deloitte.training.oodesignpatterns.structural.decorator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

import static com.deloitte.training.oodesignpatterns.structural.decorator.Ingredient.*;
import java.util.List;

public class BeverageVendingMachineTest {

    @Test
    public void buyTeaWithSugarAndLemon() {
        Beverage beverage = new Tea();
        List<Ingredient> ingredients = getIngredientsAndPrepareBeverage(beverage);

        int totalPriceOfProducts = TEA.getPrice();
        assertThat(Beverage.getTotalPrice(ingredients), is(totalPriceOfProducts));

        beverage = new WithLemon(beverage);
        ingredients = getIngredientsAndPrepareBeverage(beverage);

        totalPriceOfProducts += LEMON.getPrice();
        assertThat(Beverage.getTotalPrice(ingredients), is(totalPriceOfProducts));
        assertThat(ingredients, contains(TEA, LEMON));

        beverage = new WithSugar(beverage);
        ingredients = getIngredientsAndPrepareBeverage(beverage);

        totalPriceOfProducts += SUGAR.getPrice();
        assertThat(Beverage.getTotalPrice(ingredients), is(totalPriceOfProducts));
        assertThat(ingredients, contains(TEA, LEMON, SUGAR));
    }

    @Test
    public void buyCoffeeWithMilkSugarAndCinnamon() {
        Beverage beverage = new WithCinnamon(new WithSugar(new WithMilk(new Coffee())));
        List<Ingredient> ingredients = getIngredientsAndPrepareBeverage(beverage);

        int totalPriceOfProducts = COFFEE.getPrice() + MILK.getPrice() + SUGAR.getPrice() + CINNAMON.getPrice();

        assertThat(Beverage.getTotalPrice(ingredients), is(totalPriceOfProducts));
        assertThat(ingredients, contains(COFFEE, MILK, SUGAR, CINNAMON));
    }

    private List<Ingredient> getIngredientsAndPrepareBeverage(Beverage beverage) {
        List<Ingredient> ingredients = beverage.getIngredients();

        Beverage.prepareBeverage(ingredients);

        return ingredients;
    }

}
