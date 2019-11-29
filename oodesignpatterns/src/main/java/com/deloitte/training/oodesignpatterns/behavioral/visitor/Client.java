package com.deloitte.training.oodesignpatterns.behavioral.visitor;

public class Client {

    public static void main(String[] args) {
        Item[] items = new Item[]{
            new Book(20, "1234", "Vegan recipes, noname"),
            new Book(100, "5678", "Le Rouge et le Noir, Stendhal"),
            new Fruit(10, 2, "Banana"),
            new Fruit(5, 5, "Apple")};

        int total = calculatePrice(items);
        System.out.println("Total Cost = " + total);
    }

    private static int calculatePrice(Item[] items) {
        Visitor visitor = new ShoppingCartVisitor();
        int sum = 0;
        for (Item item : items) {
            sum = sum + item.accept(visitor);
        }
        return sum;
    }
    
}
