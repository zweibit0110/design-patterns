package com.deloitte.training.oodesignpatterns.structural.facade;

public class PlaceAnOrder {

    public static void main(String[] args) {
        OrderFacade facade = new OrderFacade(new OrderService(), new InventoryService(), new DeliveryService(), new PaymentService());

        String orderId = "123";

        System.out.println(facade.placeOrder(orderId));
    }
    
}
