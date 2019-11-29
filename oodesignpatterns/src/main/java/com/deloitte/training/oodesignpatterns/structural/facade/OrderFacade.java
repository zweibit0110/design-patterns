package com.deloitte.training.oodesignpatterns.structural.facade;

public class OrderFacade {

    private OrderService orderService;

    private InventoryService inventoryService;

    private DeliveryService deliveryService;

    private PaymentService paymentService;

    public OrderFacade(OrderService orderService, InventoryService inventoryService, DeliveryService deliveryService, PaymentService paymentService) {
        this.orderService = orderService;
        this.inventoryService = inventoryService;
        this.deliveryService = deliveryService;
        this.paymentService = paymentService;
    }

    public String placeOrder(String orderId) {
        StringBuilder result = new StringBuilder();
        result.
                append("-------------------------").
                append("\n").
                append(orderService.processOrder(orderId)).
                append("\n").
                append(inventoryService.checkInventory(orderId)).
                append("\n").
                append(deliveryService.assignDelivery(orderId)).
                append("\n").
                append(paymentService.pay(orderId)).
                append("\n").
                append(String.format("Order %s has been placed", orderId)).
                append("\n").
                append("-------------------------");

        return result.toString();
    }

}
