package com.deloitte.training.oodesignpatterns.behavioral.templateMethod;

public class GlassHouse extends HouseTemplate {

    @Override
    public void buildWalls() {
        System.out.println("{glass} Building Glass Walls");
    }

    @Override
    public void buildPillars() {
        System.out.println("{glass} Building Pillars with glass coating");
    }

}
