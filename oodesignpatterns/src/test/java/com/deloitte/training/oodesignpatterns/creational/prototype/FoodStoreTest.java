package com.deloitte.training.oodesignpatterns.creational.prototype;

import java.util.List;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Before;
import org.junit.Test;

public class FoodStoreTest {
    
    private FoodStore foodStore;
    
    private FoodStore foodStore2;
    
    @Before
    public void createStores() {
        foodStore = new FoodStore();
        
        foodStore2 = (FoodStore) foodStore.customClone();
    }
    
    @Test
    public void theStoresAreDifferent() {
        assertNotSame(foodStore, foodStore2);
    }
    
    @Test
    public void theStoresHaveTheSameAliments() {
        assertEquals(foodStore.getAliments(), foodStore2.getAliments());
    }
    
    @Test
    public void theStoresHaveASingleListOfAlimentsSharedBetweenThem() {
        assertSame(foodStore.getAliments(), foodStore2.getAliments());
    }
    
    @Test
    public void theStoresHaveTheSameAlimentsAfterModifications() {
        List<Aliment> aliments = foodStore.getAliments();
        List<Aliment> aliments2 = foodStore2.getAliments();
        
        assertEquals(aliments, aliments2);
        
        aliments.add(Aliment.APPLES);
        
        aliments2.remove(Aliment.BREAD);
        aliments2.add(Aliment.WINE);
        
        assertEquals(aliments, aliments2);
        
        assertThat(aliments, hasItems(Aliment.MEAT, Aliment.POTATOES, Aliment.APPLES, Aliment.APPLES));
        assertThat(aliments2, contains(Aliment.MEAT, Aliment.POTATOES, Aliment.APPLES, Aliment.WINE));
        
        assertSame(aliments, aliments2);
    }
    
}
