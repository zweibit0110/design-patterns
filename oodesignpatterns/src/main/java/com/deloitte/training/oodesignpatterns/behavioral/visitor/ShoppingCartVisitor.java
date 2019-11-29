package com.deloitte.training.oodesignpatterns.behavioral.visitor;

public class ShoppingCartVisitor implements Visitor {

    @Override
    public int visit(Book book) {
        int cost = 0;
        //apply 5$ discount if book price is greater than 50
        if (book.getPrice() > 50) {
            cost = book.getPrice() - 5;
        } else {
            cost = book.getPrice();
        }

        displayItemCost(book, cost);

        return cost;
    }

    private void displayItemCost(Item item, int cost) {
        System.out.println(String.format("%s cost is %d", item.toString(), cost));
    }

    @Override
    public int visit(Fruit fruit) {
        int cost = fruit.getPricePerKg() * fruit.getWeight();

        displayItemCost(fruit, cost);

        return cost;
    }

}
