package com.deloitte.training.oodesignpatterns.structural.facade;

public class InventoryService {

    public String checkInventory(String orderId) {
        return String.format("inventory was checked for order %s", orderId);
    }
    
}
