package com.deloitte.training.oodesignpatterns.structural.facade;

public class OrderService {

    public String processOrder(String orderId) {
        return String.format("processing order %s", orderId);
    }

}
