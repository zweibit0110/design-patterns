package com.deloitte.training.oodesignpatterns.creational.prototype_2;

import java.util.ArrayList;
import java.util.List;

public class ElectronicStore implements Cloneable {

    List<Product> products;

    public ElectronicStore(List<Product> products) {
        this.products = products;
    }

    public ElectronicStore() {
        this.gatherProducts();
    }

    private void gatherProducts() {
        products = new ArrayList<>();
        products.add(new Product("laptop", 34));
        products.add(new Product("watch", 45));

    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    protected Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        return clone;
    }
}
