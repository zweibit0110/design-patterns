package com.deloitte.training.oodesignpatterns.creational.prototype;

import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;

public class ElectronicStoreTest {
    
    private ElectronicStore eStore;
    
    private ElectronicStore eStore2;
    
    @Before
    public void createStores() {
        eStore = new ElectronicStore();
        eStore2 = (ElectronicStore) eStore.customClone();
    }
    
    @Test
    public void theStoresAreDifferent() {
        assertNotSame(eStore, eStore2);
    }
    
    @Test
    public void theStoresHaveTheSameProducts() {
        assertEquals(eStore.getProducts(), eStore2.getProducts());
    }
    
    @Test
    public void theStoresHaveDifferentListOfProducts() {
        assertNotSame(eStore.getProducts(), eStore2.getProducts());
    }
    
    @Test
    public void theStoresHaveDifferentProductsAfterModifications() {
        List<Product> products = eStore.getProducts();
        List<Product> products2 = eStore2.getProducts();
        
        assertEquals(products, products2);
        
        products.add(Product.PLAYSTATION);
        
        products2.remove(Product.LAPTOP);
        products2.add(Product.SMARTWATCH);
        
        assertNotEquals(products, products2);
        
        assertThat(products, hasItem(Product.PLAYSTATION));
        assertThat(products2, not(hasItem(Product.PLAYSTATION)));
        
        assertThat(products, not(hasItem(Product.SMARTWATCH)));
        assertThat(products2, hasItem(Product.SMARTWATCH));
        
        assertThat(products, hasItems(Product.LAPTOP, Product.TABLET, Product.PHONE, Product.PLAYSTATION));
        assertThat(products2, containsInAnyOrder(Product.TABLET, Product.PHONE, Product.SMARTWATCH));
        
        assertNotSame(products, products2);
    }
}
