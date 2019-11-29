package com.deloitte.training.oodesignpatterns.structural.decorator;

public enum Ingredient {

    TEA("tea", 10),
    COFFEE("coffee", 15),
    CINNAMON("cinnamon", 1),
    SUGAR("sugar", 3),
    LEMON("lemon", 5),
    MILK("milk", 7);

    private String name;

    private int price;

    Ingredient(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

}
