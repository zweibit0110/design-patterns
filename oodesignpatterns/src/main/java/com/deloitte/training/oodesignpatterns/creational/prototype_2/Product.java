package com.deloitte.training.oodesignpatterns.creational.prototype_2;

public class Product {

    String name;
    int id;

    public Product(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
