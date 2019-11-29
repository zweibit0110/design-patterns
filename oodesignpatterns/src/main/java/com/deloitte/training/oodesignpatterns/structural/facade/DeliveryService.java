package com.deloitte.training.oodesignpatterns.structural.facade;

public class DeliveryService {

    public String assignDelivery(String orderId) {
        return String.format("delivery has been assigned for order %s", orderId);
    }
    
}
