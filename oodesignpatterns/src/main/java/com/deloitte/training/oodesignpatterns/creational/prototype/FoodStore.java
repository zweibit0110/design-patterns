package com.deloitte.training.oodesignpatterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FoodStore implements Prototype, Cloneable {
    
    private List<Aliment> aliments;

    public FoodStore(List<Aliment> aliments) {
        this.aliments = aliments;
    }

    public FoodStore() {
        this.gatherAliments();
    }

    private void gatherAliments() {
        // ...
        // Gathering of aliments can take very long time
        // ...
        aliments = new ArrayList<>();
        aliments.add(Aliment.BREAD);
        aliments.add(Aliment.MEAT);
        aliments.add(Aliment.POTATOES);
    }

    public List<Aliment> getAliments() {
        return aliments;
    }

    @Override
    public Prototype customClone() {
        try {
            return (Prototype) this.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(FoodStore.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
}
