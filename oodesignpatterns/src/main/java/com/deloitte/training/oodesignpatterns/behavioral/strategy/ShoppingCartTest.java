package com.deloitte.training.oodesignpatterns.behavioral.strategy;

public class ShoppingCartTest {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem(new Item("1234", 10));
        cart.addItem(new Item("5678", 40));

        //pay by paypal
        cart.pay(new PaypalStrategy("myself@example.com", "pa$$w0rd"));

        cart.clear();
        
        cart.addItem(new Item("0000", 100));
        cart.addItem(new Item("1111", 300));
        cart.addItem(new Item("9999", 500));
        
        //pay by credit card
        cart.pay(new CreditCardStrategy("Mihai Sandu", "1234-0000-9999-0000-4321-1111", "000", "01/01"));
    }
    
}
