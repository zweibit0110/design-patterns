package com.deloitte.training.oodesignpatterns.structural.facade;

public class PaymentService {

    public String pay(String orderId) {
        return String.format("payment has been done for order %s", orderId);
    }
    
}
