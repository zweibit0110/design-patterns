package com.deloitte.training.oodesignpatterns.behavioral.visitor;

import java.util.stream.Stream;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class ShoppingCartTest {

    @Test
    public void buySomeBooks() {
        Item[] items = new Item[]{
            new Book(20, "1234", "Vegan recipes, noname"),
            new Book(100, "5678", "Le Rouge et le Noir, Stendhal"),
            new Book(60, "9834", "Rethinking Enterprise Design Patterns, Adam Bien")};

        int totalPrice = Stream.of(items).mapToInt(item -> ((Book) item).getPrice()).sum();
        int totalCost = calculateTotalCost(items);

        assertThat(totalPrice, is(not(totalCost)));
        assertThat(totalPrice, is(greaterThan(totalCost)));
    }

    private int calculateTotalCost(Item[] items) {
        Visitor visitor = new ShoppingCartVisitor();
        return Stream.of(items).
                mapToInt(item -> item.accept(visitor)).
                sum();
    }

    @Test
    public void buySomeFruits() {
        Item[] items = new Item[]{
            new Fruit(10, 2, "Banana"),
            new Fruit(5, 5, "Apple"),
            new Fruit(7, 1, "Orange")};

        int totalPrice = Stream.of(items).
                map(item -> (Fruit) item).
                mapToInt(fruit -> fruit.getPricePerKg() * fruit.getWeight()).
                sum();
        int totalCost = calculateTotalCost(items);

        assertThat(totalPrice, is(totalCost));
    }

}
