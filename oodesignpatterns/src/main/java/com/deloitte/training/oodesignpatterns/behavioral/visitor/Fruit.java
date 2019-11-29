package com.deloitte.training.oodesignpatterns.behavioral.visitor;

public class Fruit implements Item {

    private int pricePerKg;
    
    private int weight;
    
    private String name;

    public Fruit(int pricePerKg, int weight, String name) {
        this.pricePerKg = pricePerKg;
        this.weight = weight;
        this.name = name;
    }

    public int getPricePerKg() {
        return pricePerKg;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Fruit{" + "pricePerKg=" + pricePerKg + ", weight=" + weight + ", name=" + name + '}';
    }

}
