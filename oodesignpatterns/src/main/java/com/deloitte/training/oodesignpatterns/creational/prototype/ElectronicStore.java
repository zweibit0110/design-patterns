package com.deloitte.training.oodesignpatterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class ElectronicStore implements Prototype {

    private List<Product> products;
    
    public ElectronicStore(List<Product> products) {
        this.products = products;
    }

    public ElectronicStore() {
        this.gatherProducts();
    }
    
    private void gatherProducts() {
        // ...
        // Gathering of products can take very long time
        // ...
        products = new ArrayList<>();
        products.add(Product.LAPTOP);
        products.add(Product.TABLET);
        products.add(Product.PHONE);
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Prototype customClone() {
        List<Product> clonedProducts = new ArrayList<>();
        
        clonedProducts.addAll(products);
        
        return new ElectronicStore(clonedProducts);
    }
}
