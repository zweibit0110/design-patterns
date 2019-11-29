package com.deloitte.training.oodesignpatterns.creational.prototype_2;

import com.deloitte.training.oodesignpatterns.creational.prototype_2.ElectronicStore;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ElectronicStoreTest {

    ElectronicStore estore;

    ElectronicStore estore2;

    @Before
    public void createStores() {
        estore = new ElectronicStore();
        estore2 = (ElectronicStore) estore.clone();
    }

    @Test
    public void theStoresAreDifferent() {
        assertNotSame(estore, estore2);
    }

    @Test
    public void theStoresHaveSameProducts() {
        assertEquals(estore.getProducts(), estore2.getProducts());
     }

}