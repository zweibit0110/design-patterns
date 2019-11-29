package com.deloitte.training.oodesignpatterns.behavioral.templateMethod;

public class WoodenHouse extends HouseTemplate {

    @Override
    public void buildWalls() {
        System.out.println("{wood} Building Wooden Walls");
    }

    @Override
    public void buildPillars() {
        System.out.println("{wood} Building Pillars with Wood coating");
    }

}
